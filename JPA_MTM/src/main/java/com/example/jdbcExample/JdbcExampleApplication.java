package com.example.jdbcExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcExample.entity.OrderEntity;
import com.example.jdbcExample.entity.OrderProduct;
import com.example.jdbcExample.entity.ProductEntity;
import com.example.jdbcExample.repository.OrderProductRepository;
import com.example.jdbcExample.repository.OrderRepository;
import com.example.jdbcExample.repository.ProductRepository;



@SpringBootApplication
@RestController
public class JdbcExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JdbcExampleApplication.class, args);
	}
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderProductRepository orderProductRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//Order - OrderProduct - Product : n - n
		System.out.println("Hello Many to many");
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName("Áo sơ mi");
		productRepository.save(productEntity);
		
		OrderEntity newOrder = new OrderEntity();
		newOrder.setName("Đơn hàng 1");
		orderRepository.save(newOrder);
		
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setProduct(productEntity);
		orderProduct.setOrder(newOrder);
		orderProduct.setQuantity(1000);
		
		orderProductRepository.save(orderProduct);
		
		orderProductRepository.delete(orderProduct);
		productRepository.delete(productEntity);
		orderRepository.delete(newOrder);
	}
	//http://localhost:8080/
	@GetMapping
	public void test() {
	}

}
