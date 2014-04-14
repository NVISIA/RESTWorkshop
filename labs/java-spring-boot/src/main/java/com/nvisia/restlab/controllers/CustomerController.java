package com.nvisia.restlab.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nvisia.restlab.integrations.CustomerRepository;
import com.nvisia.restlab.models.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		List<Customer> retVal = new ArrayList<Customer>();
		
		for (Customer customer: customerRepo.findAll()) {
			retVal.add(customer);
		}
		
		return retVal;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepo.findOne(id);
	}
}
