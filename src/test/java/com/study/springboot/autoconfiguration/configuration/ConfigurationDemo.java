package com.study.springboot.autoconfiguration.configuration;

import com.study.springboot.autoconfiguration.bean.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:00
 */
@Configuration
public class ConfigurationDemo {
    //bean 的名称为方法名，默认为单列，使用@Scope更改
    @Bean
    public People people(){
        return new People();
    }

}
