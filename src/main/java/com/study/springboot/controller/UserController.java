package com.study.springboot.controller;

import com.study.springboot.entity.User;
import com.study.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    @ResponseBody
    public List getAllUser(){
        return userService.findAll();
    }

    @PostMapping("addUser")
    @ResponseBody
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }


}
