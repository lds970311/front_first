// Author : evan lee
// Time ： 2022-03-12  4:07
// FILENAME : AmqpPublisher.java
// STATEMENT: 

package cn.itcast.mq.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void publishMessage() {
        //队列名称
        String queueName = "simple.queue";
        rabbitTemplate.convertAndSend(queueName, "呵呵123");
    }

    @Test
    public void testWorkQueue() throws InterruptedException {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, message_";
        for (int i = 0; i < 50; i++) {
            // 发送消息
            rabbitTemplate.convertAndSend(queueName, message + i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testFanoutExchange() {
        // 队列名称
        String exchangeName = "evan.fanout";
        // 消息
        String message = "hello, everyone!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange() {
        // 交换机名称
        String exchangeName = "evan.direct";
        // 消息
        String message = "红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "yellow", message);
    }

    @Test
    public void testSendTopicExchange() {
        // 交换机名称
        String exchangeName = "evan.topic";
        // 消息
        Map<String, Object> message = new HashMap<>();
        message.put("1", "evan");
        message.put("2", "suse");
        message.put("3", "lucy");
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
    }
}
