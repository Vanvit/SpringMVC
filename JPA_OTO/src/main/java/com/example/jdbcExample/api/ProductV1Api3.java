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
public class ProductV1Api3 {

	@PersistenceContext
	private EntityManager entityManage;
	@Autowired
	private ProductRepository prRepository;


}
