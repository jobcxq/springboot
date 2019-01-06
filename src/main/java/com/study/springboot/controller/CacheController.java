package com.study.springboot.controller;

import com.study.springboot.entity.User;
import com.study.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById/{id}")
    public User findById (@PathVariable("id") Integer id){
        return userService.findById(id);
    }

}
