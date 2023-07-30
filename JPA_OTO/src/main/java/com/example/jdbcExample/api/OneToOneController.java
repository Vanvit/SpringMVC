package com.example.jdbcExample.api;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcExample.entity.InventoryEntity;
import com.example.jdbcExample.entity.ProductEntity;
import com.example.jdbcExample.repository.InventoryRepository;
import com.example.jdbcExample.repository.ProductRepository;

@RestController
public class OneToOneController {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@GetMapping("OneToOne")
	@Transactional
	public void test() {
		ProductEntity pEntity = new ProductEntity();
		pEntity.setProductName("ao so mi");
		pEntity.setPrice(25444L);
		productRepository.save(pEntity);
		
		InventoryEntity inEntity = new InventoryEntity();
		inEntity.setProduct(pEntity);
		inEntity.setQuantity(12);
		inventoryRepository.save(inEntity);
		
		// set lai -> Neu k InventoryID cua Produdcts se bi null
		pEntity.setInventoryEntity(inEntity);
		productRepository.save(pEntity);

	}
	
	@GetMapping("getById")
	@Transactional
	public void getById() {
		
		Optional<ProductEntity> pOptional = productRepository.findById(2L);
		if(pOptional.isPresent()) {
			ProductEntity productEntity = pOptional.get();
			System.out.println(productEntity.getProductName());
//			System.out.println(productEntity.getInventoryEntity().getInventoryId());
			System.out.println(productEntity.getInventoryEntity().getQuantity());
		}
	}
	
	@GetMapping("deleteOTO")
	@Transactional
	public void deleteOTO() {
		
		Optional<ProductEntity> productOpt = productRepository.findById(2L);
		if (productOpt.isPresent()) {
			ProductEntity productEntity = productOpt.get();
			InventoryEntity inventory = productEntity.getInventoryEntity();
			
			productEntity.setInventoryEntity(null);
			productRepository.save(productEntity);
			inventoryRepository.delete(inventory);
			productRepository.delete(productEntity);
		
		}
			
		
	}

}
