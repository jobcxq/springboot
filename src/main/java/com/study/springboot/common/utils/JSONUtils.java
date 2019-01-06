package com.study.springboot.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils{

    public static String toJSONString(Object object) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Object parse(String json, Class clazz){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json,clazz);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
