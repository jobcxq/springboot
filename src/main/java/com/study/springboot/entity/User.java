package com.study.springboot.entity;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.data.redis.serializer.SerializationException;

import javax.persistence.*;
import java.io.*;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    @Column(name = "name",length = 50)
    private String name;

    @Column
    private Integer age;

    @Column
    private String sex;

    @Column
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public byte[] serialize(User user) throws SerializationException {
        if(user == null){
            return null;
        }
        return JSONUtils.toJSONString(user).getBytes();
    }

    public User deserialize(byte[] bytes) throws SerializationException {
        if(bytes == null) return null;
        return (User)JSONUtils.parse(new String(bytes));
    }
}
