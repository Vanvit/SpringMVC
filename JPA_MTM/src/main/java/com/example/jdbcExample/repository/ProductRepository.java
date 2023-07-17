package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
