package com.study.springboot.annotation.ImportSelector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:59
 */
//@SpringBootApplication
@MyEnableAutoConfiguration(exclude={CacheService.class})
public class ImportSelectorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ImportSelectorTest.class);

        for(String name : applicationContext.getBeanDefinitionNames()){
            System.out.println(name);
        }


//        ConfigurableApplicationContext applicationContext =
//                SpringApplication.run(ImportSelectorTest.class,args);
//        System.out.println(applicationContext.getBean(LoggerService.class));
    }

}
