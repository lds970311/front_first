// Author : evan lee
// Time ： 2022-03-20  20:46
// FILENAME : ElasticSearchConfig.java
// STATEMENT: 

package cn.evan.hotel.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.208.149:9200")
        ));
    }
}
