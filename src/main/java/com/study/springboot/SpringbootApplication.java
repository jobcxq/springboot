package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */

/**
 * 整合rabbitMQ
 *
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、自动配置连接工厂 ConnectionFactory
 * 3、RabbitProperties 封装了 RabbitMQ 的配置
 * 4、RabbitAutoConfiguration中的 RabbitTemplate 给RabbitMQ发送和接收消息
 * 5、AmpqAdmin：RabbitMq系统管理功能组件，创建、删除队列，交换器等和绑定规则
 * 6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 *
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringbootApplication {

	private final static Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		log.info("================================================");
		log.info("system is started successful!");
	}
}
