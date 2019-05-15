package com.mitra.eventuatedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitra.eventuatedemo.model.Customer;
import com.mitra.eventuatedemo.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public Customer getCustomer(@RequestParam("entityId") String entityId) {

		return customerService.getCustomer(entityId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
}
