package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{

}
