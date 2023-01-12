package com.customer.rest.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.rest.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Page<Account> findByCustomerCustomerId(Integer customerId, Pageable pageable);
}
