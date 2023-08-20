package com.example.jdbcExample.repository.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long>{
	
	

}
