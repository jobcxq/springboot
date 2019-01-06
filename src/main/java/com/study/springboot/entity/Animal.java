package com.study.springboot.entity;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.data.redis.serializer.SerializationException;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANIMAL")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    @Column(name = "name",length = 50)
    private String name;

    @Column
    private Integer age;

    @Column
    private String sex;

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

}
