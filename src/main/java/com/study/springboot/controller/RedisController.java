package com.study.springboot.controller;

import com.study.springboot.entity.User;
import com.study.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/findNameById/{id}")
    public String findNameById (@PathVariable("id") Integer id){
        return redisService.findNameById(id);
    }

    @RequestMapping("/findById/{id}")
    public User findById (@PathVariable("id") Integer id){
        return redisService.findById(id);
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List getAllUser(){
        return redisService.findAll();
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user){
        return redisService.save(user);
    }



}
