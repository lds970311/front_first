// Author : evan lee
// Time ： 2022-03-21  18:32
// FILENAME : AggregationTest.java
// STATEMENT: 

package cn.evan.hotel;

import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

//数据聚合
@SpringBootTest
public class AggregationTest {
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
    void aggregation() throws IOException {
        //准备request
        SearchRequest searchRequest = new SearchRequest("hotel");
        searchRequest.source().size(0);
        searchRequest.source().aggregation(
                AggregationBuilders.terms("brandAgg")
                        .field("brand")
                        .size(20)
        );
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        this.handleResult(search, "brandAgg");

    }

    private void handleResult(SearchResponse searchResponse, String aggregationString) {
        SearchHits searchHits = searchResponse.getHits();
        long value = searchHits.getTotalHits().value;
        System.out.println("total=" + value);
        Aggregations aggregations = searchResponse.getAggregations();
        //根据聚合名称获取聚合结果
        Terms terms = aggregations.get(aggregationString);
        //获取桶
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            //获取key
            String key = bucket.getKeyAsString();
            System.out.println(key);
        }
    }
}
