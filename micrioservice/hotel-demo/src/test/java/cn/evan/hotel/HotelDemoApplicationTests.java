package cn.evan.hotel;

import cn.evan.hotel.constants.HotelIndex;
import org.apache.http.HttpHost;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HotelDemoApplicationTests {

    private static RestHighLevelClient client;

    @BeforeAll
    static void restClientTest() {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.208.149:9200")
        ));
        System.out.println(client);
    }

    @Test
    void createIndexes() throws IOException {
        CreateIndexRequest hotel = new CreateIndexRequest("hotel");
        hotel.source(HotelIndex.HOTEL_INDEX, XContentType.JSON);
        IndicesClient indices = client.indices();
        indices.create(hotel, RequestOptions.DEFAULT);
    }
}
