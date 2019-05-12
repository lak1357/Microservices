package com.mitra.eventuatedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mitra.eventuatedemo.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String getCustomer() {
		return customerService.getCustomer();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createCustomer() {
		return customerService.createCustomer();
	}
}
