package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jdbcExample.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{

}
