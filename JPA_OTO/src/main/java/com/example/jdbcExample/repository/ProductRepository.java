package com.example.jdbcExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jdbcExample.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>{
	
	List<ProductEntity> findByProductName(String name);
	
	List<ProductEntity> findAllByProductNameAndPrice(String productName, Long price);
	
//	List<ProductEntity> findAllByPriceGreaterThan(Long price);
	
//	@Query("Select p From ProductEntity p Where p.price > :price") //HQL
//	List<ProductEntity> findAllPrice(@Param("price") Long Price);
	
	@Query(value = "Select * From products  Where price > :price",nativeQuery = true) //SQL
	List<ProductEntity> findAllPriceNativeQL(@Param("price") Long Price);
	
	

}
