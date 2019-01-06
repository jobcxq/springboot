package com.study.springboot.dao;

import com.study.springboot.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDao extends JpaRepository<Animal,Integer> {
}
