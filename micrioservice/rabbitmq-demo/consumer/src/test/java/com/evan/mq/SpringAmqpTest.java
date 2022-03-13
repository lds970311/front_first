// Author : evan lee
// Time ： 2022-03-12  4:01
// FILENAME : SpringAmqpTest.java
// STATEMENT: 

package com.evan.mq;

import cn.itcast.mq.helloworld.ConsumerTest;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConsumerTest.class})
public class SpringAmqpTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

}
