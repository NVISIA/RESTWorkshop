package com.nvisia.restlab.integrations;

import org.springframework.data.repository.CrudRepository;

import com.nvisia.restlab.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
