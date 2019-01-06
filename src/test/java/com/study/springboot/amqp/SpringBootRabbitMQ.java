package com.study.springboot.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitMQ {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 点对点： direct
     */
    @Test
    public void sendDirect() {

        //需要自己定义 Message
        //rabbitTemplate.send(String exchange, String routingKey, Message message);

        //object`默认为消息体，自动序列化发送mq
        //rabbitTemplate.convertAndSend(exchange,routingKey,object);
        Map messgae = new HashMap<>();
        messgae.put("from","spring-boot");
        messgae.put("author","陈小钦");
        messgae.put("msg","HelloWorld!");
        //默认使用java序列化-转换器 MessageConverter
        //在AmqpConfig中配置自定义转换器
        rabbitTemplate.convertAndSend("cxq.direct","xiaoqin",messgae);
    }

    @Test
    public void receive(){
        //接收消息
        rabbitTemplate.receiveAndConvert("xiaoqin");
    }

    /**
     * 广播 fanout
     */
    @Test
    public void sendFanout(){
        Map messgae = new HashMap<>();
        messgae.put("from","spring-boot");
        messgae.put("author","陈小钦");
        messgae.put("msg","HelloWorld!");
        rabbitTemplate.convertAndSend("cxq.fanout","",messgae);
    }

    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,
                "amqpadmin.exchange","amqpadmin.key",null));
    }

}
