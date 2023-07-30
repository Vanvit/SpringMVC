package com.example.jdbcExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventory") // ONE TO ONE
public class InventoryEntity {
	@Id // primary key
	@Column(name="inventoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;

	
	@Column(name="quantity")
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name="productId")
	private ProductEntity product;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		product.setInventoryEntity(this);
		this.product = product;
	}
	
	
	

	

}
