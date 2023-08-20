package com.example.jdbcExample.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	

}
