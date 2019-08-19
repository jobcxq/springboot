package com.study.springboot.annotation.ImportSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:54
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({MyAutoConfigurationImportSelector.class,MyAutoConfigurationRegistrar.class})
public @interface MyEnableAutoConfiguration {

    Class<?>[] exclude() default {};

    String[] excludeName() default {};

}
