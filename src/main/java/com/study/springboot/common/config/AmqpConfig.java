package com.study.springboot.common.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Bean
    //自定义消息发送转换器
    public MessageConverter messageConvert(){
        return new Jackson2JsonMessageConverter();
    }
}
