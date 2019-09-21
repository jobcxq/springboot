package com.study.springboot.autoconfiguration.ImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cnxqin
 * @desc
 * @date 2019/08/19 22:53
 */

public class MyAutoConfigurationImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        Map<String, Object> map = annotationMetadata
                .getAnnotationAttributes(MyEnableAutoConfiguration.class.getName());
        String[] strs = new String[]{CacheService.class.getName(),LoggerService.class.getName()};

        List<String> list = new ArrayList<>(Arrays.asList(strs));

        if(map.containsKey("exclude") && ((Class<?>[])map.get("exclude")).length > 0){
            for(Class clazz : (Class<?>[])map.get("exclude")){
                list.remove(clazz.getName());
            }
            return list.toArray(new String[list.size()]);
        }

        return strs;
    }

}
