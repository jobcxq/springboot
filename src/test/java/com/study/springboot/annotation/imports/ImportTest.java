package com.study.springboot.annotation.imports;

import com.study.springboot.annotation.configuration.ConfigurationDemoTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:32
 */
public class ImportTest {

    public static void main(String[] args){

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConfigurationDemo.class);

        for(String name : applicationContext.getBeanDefinitionNames()){
            System.out.println(name);
        }

    }

}
