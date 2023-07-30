package com.example.jdbcExample.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity {
	@Id // primary key
	@Column(name="productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name="productName")
	private String  productName;
	
	@Column(name="price")
	private Long price;
	
	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="inventoryId")
	private InventoryEntity inventoryEntity;
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	

	public InventoryEntity getInventoryEntity() {
		return inventoryEntity;
	}

	public void setInventoryEntity(InventoryEntity inventoryEntity) {
		this.inventoryEntity = inventoryEntity;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	
	
}
