package com.study.springboot.service;

import com.study.springboot.dao.UserDao;
import com.study.springboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheService {

    Logger log = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    private UserDao userDao;

    @Cacheable(cacheNames = {"user"})
    public User findById (Integer id){
        log.info("根据ID查询用户信息：id=" + id);
        return userDao.findById(id).get();
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User save(User user){
        return userDao.save(user);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }

}
