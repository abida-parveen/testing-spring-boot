package com.customer.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.rest.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}