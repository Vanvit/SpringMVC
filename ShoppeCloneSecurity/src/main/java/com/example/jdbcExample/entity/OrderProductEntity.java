package com.example.jdbcExample.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long OrderProductId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_Id", nullable = false)
	private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="order_Id", nullable = false)
	private OrderEntity order;
	
	private Integer quantity;

	public Long getOrderProductId() {
		return OrderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		OrderProductId = orderProductId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	 
	
	

}
