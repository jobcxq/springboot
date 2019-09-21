package com.study.springboot.autoconfiguration.imports;

import com.study.springboot.autoconfiguration.bean.DefaultConfiguration;
import com.study.springboot.autoconfiguration.bean.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:00
 */
@Configuration
@Import(DefaultConfiguration.class)
public class ConfigurationDemo {
    //bean 的名称为方法名，默认为单列，使用@Scope更改
    @Bean
    public People people(){
        return new People();
    }

}
