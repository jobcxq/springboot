package com.study.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
@RequestMapping("/helloworld")
public class HelloController {

    Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DataSource dataSource;

    @ResponseBody
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name) {
        System.out.println(dataSource.getClass());
        String str = "123";
        log.info("开始访问hello方法，请求参数：name=" + name);
        this.test(str, 1);

        return name + " helloworld!";

    }

    /**
     * 哈哈，测试
     *
     * @param string 入参
     * @param i      入参 i
     * @return 出参
     */

    public String test(String string, int i) {
        return null;
    }

}
