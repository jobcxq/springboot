package com.study.springboot.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:30
 */
@Configuration
public class DefaultConfiguration {

    @Bean
    public Student student(){
        return new Student();
    }
}
