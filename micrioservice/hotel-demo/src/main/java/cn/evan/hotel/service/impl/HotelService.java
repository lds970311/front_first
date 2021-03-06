package cn.evan.hotel.service.impl;

import cn.evan.hotel.mapper.HotelMapper;
import cn.evan.hotel.pojo.Hotel;
import cn.evan.hotel.pojo.HotelDoc;
import cn.evan.hotel.pojo.PageResult;
import cn.evan.hotel.pojo.RequestParams;
import cn.evan.hotel.service.IHotelService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public PageResult searchHotels(RequestParams params) {
        try {
            // 1.??????Request
            SearchRequest request = new SearchRequest("hotel");
            // 2.??????????????????
            // 2.1.query
            buildBasicQuery(params, request);
            // 2.2.??????
            int page = params.getPage();
            int size = params.getSize();
            request.source().from((page - 1) * size).size(size);
            // 2.3.????????????
            String location = params.getLocation();
            if (StringUtils.isNotBlank(location)) {
                request.source().sort(SortBuilders
                        .geoDistanceSort("location", new GeoPoint(location))
                        .order(SortOrder.ASC)
                        .unit(DistanceUnit.KILOMETERS)
                );
            }
            // 3.????????????
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            // 4.????????????
            return handleResponse(response);
        } catch (IOException e) {
            throw new RuntimeException("??????????????????", e);
        }
    }

    @SneakyThrows
    @Override
    public Map<String, List<String>> filters(RequestParams requestParams) {
        Map<String, List<String>> filterMap = new HashMap<>();
        //??????request
        SearchRequest searchRequest = new SearchRequest("hotel");
        searchRequest.source().size(0);
        //??????????????????,??????????????????
        this.buildBasicQuery(requestParams, searchRequest);
        this.buildAggregation(searchRequest, filterMap);
        return filterMap;
    }

    @SneakyThrows
    @Override
    /**
     * ?????????????????????
     */
    public List<String> getSuggestions(String key) {
        SearchRequest searchRequest = new SearchRequest("hotel");
        searchRequest.source()
                .suggest(new SuggestBuilder().addSuggestion("suggestion",
                        SuggestBuilders.completionSuggestion("suggestion")
                                .prefix(key)
                                .skipDuplicates(true)
                                .size(10)));
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return this.handleSuggestions(response);
    }

    @Override
    public void deleteById(Long id) {
        try {
            // 1.??????Request
            DeleteRequest request = new DeleteRequest("hotel", id.toString());
            // 2.????????????
            restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertById(Long id) {
        try {
            // 0.??????id??????????????????
            Hotel hotel = getById(id);
            // ?????????????????????
            HotelDoc hotelDoc = new HotelDoc(hotel);

            // 1.??????Request??????
            IndexRequest request = new IndexRequest("hotel").id(hotel.getId().toString());
            // 2.??????Json??????
            request.source(JSON.toJSONString(hotelDoc), XContentType.JSON);
            // 3.????????????
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> handleSuggestions(SearchResponse response) {
        List<String> suggestions = new ArrayList<>();
        Suggest suggest = response.getSuggest();
        //????????????????????????, ??????????????????
        CompletionSuggestion suggestion = suggest.getSuggestion("suggestion");
        List<CompletionSuggestion.Entry.Option> options = suggestion.getOptions();
        for (CompletionSuggestion.Entry.Option option : options) {
            String string = option.getText().string();
            suggestions.add(string);
        }
        return suggestions;
    }

    private void buildAggregation(SearchRequest searchRequest, Map<String, List<String>> filterMap) throws IOException {
        searchRequest.source().aggregation(
                AggregationBuilders.terms("brandAgg")
                        .field("brand")
                        .size(50)
        );
        List<String> brandAgg = this.handleResult(restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT), "brandAgg");
        searchRequest.source().aggregation(
                AggregationBuilders.terms("cityAgg")
                        .field("city")
                        .size(50)
        );
        List<String> cityAgg = this.handleResult(restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT), "cityAgg");
        searchRequest.source().aggregation(
                AggregationBuilders.terms("starAgg")
                        .field("starName")
                        .size(50)
        );
        List<String> starAgg = this.handleResult(restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT), "starAgg");
        filterMap.put("??????", brandAgg);
        filterMap.put("??????", cityAgg);
        filterMap.put("??????", starAgg);
    }

    private List<String> handleResult(SearchResponse searchResponse, String aggregationString) {
        List<String> filterList = new ArrayList<>();
        SearchHits searchHits = searchResponse.getHits();
        long value = searchHits.getTotalHits().value;
        System.out.println("total=" + value);
        Aggregations aggregations = searchResponse.getAggregations();
        //????????????????????????????????????
        Terms terms = aggregations.get(aggregationString);
        //?????????
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            //??????key
            String key = bucket.getKeyAsString();
            filterList.add(key);
        }
        return filterList;
    }

    private void buildBasicQuery(RequestParams params, SearchRequest request) {
        // 1.??????Boolean??????
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        // 1.1.??????????????????match???????????????must???
        String key = params.getKey();
        if (StringUtils.isNotBlank(key)) {
            // ?????????????????????????????????
            boolQuery.must(QueryBuilders.matchQuery("all", key));
        } else {
            // ?????????????????????
            boolQuery.must(QueryBuilders.matchAllQuery());
        }

        // 1.2.??????
        String brand = params.getBrand();
        if (StringUtils.isNotBlank(brand)) {
            boolQuery.filter(QueryBuilders.termQuery("brand", brand));
        }
        // 1.3.??????
        String city = params.getCity();
        if (StringUtils.isNotBlank(city)) {
            boolQuery.filter(QueryBuilders.termQuery("city", city));
        }
        // 1.4.??????
        String starName = params.getStarName();
        if (StringUtils.isNotBlank(starName)) {
            boolQuery.filter(QueryBuilders.termQuery("starName", starName));
        }
        // 1.5.????????????
        Integer minPrice = params.getMinPrice();
        Integer maxPrice = params.getMaxPrice();
        if (minPrice != null && maxPrice != null) {
            maxPrice = maxPrice == 0 ? Integer.MAX_VALUE : maxPrice;
            boolQuery.filter(QueryBuilders.rangeQuery("price").gte(minPrice).lte(maxPrice));
        }

        // 2.??????????????????
        FunctionScoreQueryBuilder functionScoreQuery = QueryBuilders.functionScoreQuery(
                boolQuery, // ???????????????boolQuery
                new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{ // function??????
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                                QueryBuilders.termQuery("isAD", true), // ????????????
                                ScoreFunctionBuilders.weightFactorFunction(10) // ????????????
                        )
                }
        );

        // 3.??????????????????
        request.source().query(functionScoreQuery);
    }

    private PageResult handleResponse(SearchResponse response) {
        SearchHits searchHits = response.getHits();
        // 4.1.?????????
        long total = searchHits.getTotalHits().value;
        // 4.2.??????????????????
        SearchHit[] hits = searchHits.getHits();
        // 4.3.??????
        List<HotelDoc> hotels = new ArrayList<>(hits.length);
        for (SearchHit hit : hits) {
            // 4.4.??????source
            String json = hit.getSourceAsString();
            // 4.5.???????????????????????????
            HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);
            // 4.6.??????????????????
            // 1)????????????map
            Map<String, HighlightField> map = hit.getHighlightFields();
            if (map != null && !map.isEmpty()) {
                // 2???????????????????????????????????????
                HighlightField highlightField = map.get("name");
                if (highlightField != null) {
                    // 3?????????????????????????????????????????????1?????????
                    String hName = highlightField.getFragments()[0].toString();
                    // 4????????????????????????HotelDoc???
                    hotelDoc.setName(hName);
                }
            }
            // 4.8.????????????
            Object[] sortValues = hit.getSortValues();
            if (sortValues.length > 0) {
                hotelDoc.setDistance(sortValues[0]);
            }

            // 4.9.????????????
            hotels.add(hotelDoc);
        }
        return new PageResult(total, hotels);
    }
}
