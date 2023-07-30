package com.example.jdbcExample.api;

import java.util.List;

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

@RestController
@RequestMapping("api/v1/products")
public class ProductV1Api {

	@PersistenceContext
	private EntityManager entityManage;

	@GetMapping("sql")
	public void getProduct2s() {
		 //SQL using createNativeQuery.
		Query createNativeQuery = entityManage.createNativeQuery("Select * from products");
		
		List<Object[]> resultList = createNativeQuery.getResultList();
		System.out.println(resultList);
		for (Object[] objects : resultList) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
		}
	}
	
	@PostMapping("test")
	@Transactional
	public void test() {
		System.out.println("API test work");
		// update DL
		// ORM
		//1. Lay entity : find 
/*		ProductEntity productEntity = entityManage.find(ProductEntity.class, 6L);
		productEntity.setPrice(1000L);
		productEntity.setProductName("sao mi change");
		entityManage.persist(productEntity);*/
		//2. HQL / SQL
//		entityManage.createNativeQuery(""); //SQL
//		Cach1
/*		Query query = entityManage.createQuery("Update ProductEntity p SET p.price = 1000"
				+ "Where p.productName = ?1"); //HQL  sd Entity
		query.setParameter(1, "shirt");
		*/
		Query query2 = entityManage.createQuery("Update ProductEntity p SET p.price = 13000"
				+ "Where p.productName = :productName"); //HQL  sd Entity
		query2.setParameter("productName", "shirt");
		
		query2.executeUpdate();
	
	}
	
	@PostMapping("remove")
	@Transactional
	public void remove() {
	
		ProductEntity productEntity = entityManage.find(ProductEntity.class, 6L);
		entityManage.remove(productEntity);
	}


	@GetMapping("sql2")
	public List<Object[]> getProduct22s() {
		 //SQL using createNativeQuery.
		Query createNativeQuery = entityManage.createNativeQuery("Select * from products");
		
		List<Object[]> resultList = createNativeQuery.getResultList();
		System.out.println(resultList);
		for (Object[] objects : resultList) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
		}
		return resultList;
	}
	
	@GetMapping
	public List<ProductEntity> getProducts() {
		String sql="Select p from ProductEntity p";
		TypedQuery<ProductEntity> createQuery // HQL using createQuery
				= entityManage.createQuery(sql, ProductEntity.class); // HQL

		List<ProductEntity> productEntities = createQuery.getResultList();
		return productEntities;
	}

	@GetMapping("{productId}")
	public ProductEntity getProduct(@PathVariable(name = "productId") Long productId) {
		ProductEntity productEntity = entityManage.find(ProductEntity.class, productId);
		return productEntity;
	}

	@PostMapping
	@Transactional
	public void createProduct(@RequestBody ProductEntity productEntity) {
		entityManage.persist(productEntity); // create rows / insert data
		System.out.println(productEntity);
	}
	

}
