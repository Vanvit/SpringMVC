package com.example.demoBai1.service;

import java.util.List;

import com.example.demoBai1.model.Product;

public interface ProductService {
	public List<Product> findAll();

	public void save(Product product);

	public Product findById(int id);

	public void update(int id, Product product);

	public void remove(int id);

}
