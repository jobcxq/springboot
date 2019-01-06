package com.study.springboot.rabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageListenerService {

    //需要开启@EnableRabbit，会自动检测指定队列的消息
    @RabbitListener(queues = "xiaoqin")
    public void receiveObject(Map message){
        System.out.println("收到消息：" + message);
    }

    @RabbitListener(queues = "xiaoqin.chen")
    public void receiveMessage(Message message){
        System.out.println("收到消息：" + message);
    }

}
