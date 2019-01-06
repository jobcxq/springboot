package com.study.springboot.service;

import com.study.springboot.common.utils.JSONUtils;
import com.study.springboot.dao.UserDao;
import com.study.springboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;//k-v为字符串

    @Autowired
    private RedisTemplate redisTemplate;//k-v为对象

    @Autowired
    private UserDao userDao;

    public String findNameById(Integer id){
        log.info("根据ID查询用户姓名：id=" + id);
        String name = stringRedisTemplate.opsForValue().get("id-name-" + id);
        if(name != null){
            return name;
        }
        User user = userDao.findById(id).get();
        if(user != null)
            stringRedisTemplate.opsForValue().set("id-name-" + id,user.getName());
        return user.getName();
    }

    public User findById (Integer id){
        log.info("根据ID查询用户信息：id=" + id);
        String json = stringRedisTemplate.opsForValue().get("user-id-" + id);
        if(json != null){
            return (User)JSONUtils.parse(json,User.class);
        }
        User user = userDao.findById(id).get();
        stringRedisTemplate.opsForValue().set("user-id-" + id,JSONUtils.toJSONString(user));
        return user;
    }

    public List<User> findAll(){
        log.info("查询所有用户信息");
        /*默认使用jdk序列化机制,可以做如下处理
        1.将数据以json的方式保存
            （1）自己讲对象转为json
            （2）更改redis默认的序列化规则，使用自定义规则
        */
        List list = (List)redisTemplate.opsForList().leftPop("userList");
        if(list == null){
            list = userDao.findAll();
            log.info("添加用户列表到redis：" + redisTemplate.opsForList().leftPush("userList",list));
        }
        return list;
    }

    public User save(User user){
        return userDao.save(user);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }


}
