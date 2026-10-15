package com.example.springtestingdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtestingdemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
}


