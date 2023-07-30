package com.example.jdbcExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jdbcExample.entities.Customer;
import com.example.jdbcExample.entities.KhachHang;
@Repository
public interface KhachHangRepository extends JpaRepository<Customer, Integer>{


}
