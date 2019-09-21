package com.study.springboot.autoconfiguration.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:01
 */
@ComponentScan("com.study.springboot.service")
public class ConfigurationDemoTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigurationDemoTest.class);
//        System.out.println(applicationContext.getBean("people"));

        for(String name : applicationContext.getBeanDefinitionNames()){
            System.out.println(name);
        }

    }

}
