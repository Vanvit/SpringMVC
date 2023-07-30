package com.example.jdbcExample.api;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcExample.entity.ProductEntity;
import com.example.jdbcExample.repository.ProductRepository;

@RestController
@RequestMapping("api/v1/products")
public class ProductV1Api2 {

	@PersistenceContext
	private EntityManager entityManage;
	@Autowired
	private ProductRepository prRepository;
	
	
	// Them(R)
	@PostMapping("Add")
	@Transactional
	public void add() {
		

		ProductEntity prEntity = new ProductEntity();
		prEntity.setPrice(80000L);
		prEntity.setProductName("Dep ");
		prRepository.save(prEntity);
		
	}
	// Doc(R)
	@PostMapping("Read")
	@Transactional
	public void test() {
		
//		Optional<ProductEntity> productEntity = prRepository.findById(99L);
//		if(productEntity.isPresent()) {
//			System.out.println(productEntity);
//		}else {
//			System.out.println("Not found!!!");
//		}
		// k co DL se tra ve null
//		Optional<ProductEntity> prOptional = prRepository.findById(99L);
//		ProductEntity prEntity = prOptional.orElse("null");
//		System.out.println(prEntity);
		// k co DL se tra ve null
		Optional<ProductEntity> prOptional = prRepository.findById(99L);
		ProductEntity prEntity = prOptional.orElseThrow(()->new RuntimeException("K tim thay san pham"));
		System.out.println(prEntity);
	}
	
	@PostMapping("findByproductName")
	@Transactional
	public void findByproductName() {
		List<ProductEntity> prList = prRepository.findByProductName("shirt");
		System.out.println(prList);

	}
	@PostMapping("findNAP")
	@Transactional
	public void findByNameAndPrice() {
		List<ProductEntity> prList = prRepository.findAllByProductNameAndPrice("shirt", 13000L);
		System.out.println(prList);
	}
	
	@PostMapping("findByPriceThan")
	@Transactional
	public void findByPriceThan() {
//		List<ProductEntity> prList = prRepository.findAllPriceGreaterThan(14000L);
//		System.out.println(prList);
	}
	
	@PostMapping("findByPriceAll")
	@Transactional
	public void findByPriceAll() {
		List<ProductEntity> prList = prRepository.findAllPriceNativeQL(14000L);
		System.out.println(prList);
	}
	@PostMapping("update2")
	@Transactional
	public void update2() {
		Optional<ProductEntity> prOptional = prRepository.findById(66L);
		if(prOptional.isPresent()) {
			ProductEntity prEntity = prOptional.get();
			prEntity.setPrice(200000L);
			prRepository.save(prEntity);
		}
		else {
			System.out.println("Not found !!!"); 
		}

	}
	@PostMapping("delete2")
	@Transactional
	public void delete2() {
		Optional<ProductEntity> prOptional = prRepository.findById(66L);
		if(prOptional.isPresent()) {
			ProductEntity prEntity = prOptional.get();
			prRepository.delete(prEntity);
		}
		else {
			System.out.println("Not found ");
		}
		
//		prRepository.deleteById(6L);
//		prRepository.deleteAll();

	}

}
