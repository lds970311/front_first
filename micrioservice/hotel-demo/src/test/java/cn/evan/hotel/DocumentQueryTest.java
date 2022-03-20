// Author : evan lee
// Time ： 2022-03-20  19:15
// FILENAME : DocumentQueryTest.java
// STATEMENT: 

package cn.evan.hotel;

import cn.evan.hotel.pojo.HotelDoc;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
public class DocumentQueryTest {
    private static RestHighLevelClient client;

    @BeforeAll
    static void initClient() {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.208.149:9200")
        ));
    }

    @SneakyThrows
    @AfterAll
    static void closeClient() {
        client.close();
    }

    @Test
    void matchAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest("hotel");
        SearchSourceBuilder searchSourceBuilder = searchRequest.source();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        //解析响应
        this.handleResult(search);
    }

    @Test
    void testMatch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("hotel");
        SearchSourceBuilder searchSourceBuilder = searchRequest.source();
        searchSourceBuilder.query(QueryBuilders.matchQuery("brand", "如家"));
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        this.handleResult(searchResponse);
    }

    @Test
    void testExactQuest() throws IOException {
        SearchRequest searchRequest = new SearchRequest("hotel");
        SearchSourceBuilder searchSourceBuilder = searchRequest.source();
        searchSourceBuilder.query(QueryBuilders.rangeQuery("price").gte(100).lt(1000));
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        this.handleResult(searchResponse);
    }

    @Test
    void testBoolQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("hotel");
        //排序
        searchRequest.source().sort("price", SortOrder.ASC);
        //分页
        searchRequest.source()
                .from(10)
                .size(5);
        SearchSourceBuilder searchSourceBuilder = searchRequest.source();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        searchSourceBuilder.query(boolQueryBuilder);
        boolQueryBuilder.must(QueryBuilders.termQuery("city", "北京"));
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(200).lte(800));
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        this.handleResult(searchResponse);
    }


    private void handleResult(SearchResponse searchResponse) {
        SearchHits searchHits = searchResponse.getHits();
        long value = searchHits.getTotalHits().value;
        System.out.println("total=" + value);
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            System.out.println(JSON.parseObject(hit.getSourceAsString()));
        }
    }

    @SneakyThrows
    @Test
    void testHighLight() {
        SearchRequest searchRequest = new SearchRequest("hotel");
        searchRequest.source()
                .highlighter(new HighlightBuilder().field("name").requireFieldMatch(false));
        SearchSourceBuilder searchSourceBuilder = searchRequest.source();
        searchSourceBuilder.query(QueryBuilders.termQuery("city", "上海"));
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        this.handleHighLight(searchResponse);
    }

    private void handleHighLight(SearchResponse searchResponse) {
        SearchHits searchHits = searchResponse.getHits();
        long value = searchHits.getTotalHits().value;
        System.out.println("total=" + value);
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            HotelDoc hotelDoc = JSON.parseObject(hit.getSourceAsString(), HotelDoc.class);
            //处理高亮
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (!highlightFields.isEmpty()) {
                highlightFields.forEach((k, v) -> {
                    //获取高亮值
                    Text[] fragments = v.getFragments();
                    String name = fragments[0].string(); //高亮字段
                    System.out.println(name);
                });
            }
        }
    }
}
