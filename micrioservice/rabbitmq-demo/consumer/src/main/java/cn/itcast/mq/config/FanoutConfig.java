// Author : evan lee
// Time ： 2022-03-12  19:41
// FILENAME : FanoutConfig.java
// STATEMENT: 

package cn.itcast.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //evan.fanout
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("evan.fanout");
    }

    //fanout.queue1
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1");
    }

    //fanout.queue1
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2");
    }

    //把队列绑定到交换机
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue1)
                .to(fanoutExchange);
    }

    //把队列绑定到交换机
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue2)
                .to(fanoutExchange);
    }
}
