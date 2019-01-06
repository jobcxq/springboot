package com.study.springboot;

import com.alibaba.druid.support.json.JSONUtils;
import com.study.springboot.entity.User;

public class AlibabaJson {

    public static void main(String[] args) {

        User user = new User();
        user.setId(11);
        user.setName("abcd");
        user.setAddr("efghjk");
        System.out.println(JSONUtils.toJSONString(user));

    }
}
