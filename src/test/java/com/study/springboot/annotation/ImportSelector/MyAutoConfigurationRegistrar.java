package com.study.springboot.annotation.ImportSelector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 23:26
 */
public class MyAutoConfigurationRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        Class beanClass = LoggerService.class;
        String beanName = StringUtils.uncapitalize(beanClass.getSimpleName());

        BeanDefinition beanDefinition = new RootBeanDefinition(beanClass);

        registry.registerBeanDefinition(beanName,beanDefinition);
    }
}
