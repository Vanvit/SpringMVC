package com.example.demoBai1.Service;

import java.util.List;

import com.example.demoBai1.Model.Customer;

public interface CustomerService {

	List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

}
