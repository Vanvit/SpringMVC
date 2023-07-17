package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
