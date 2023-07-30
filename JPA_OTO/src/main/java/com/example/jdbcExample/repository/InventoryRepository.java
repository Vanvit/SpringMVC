package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{

}
