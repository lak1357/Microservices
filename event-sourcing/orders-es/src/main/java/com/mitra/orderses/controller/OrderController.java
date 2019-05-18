package com.mitra.orderses.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitra.orderses.dto.CoffeeOrder;
import com.mitra.orderses.dto.Order;
import com.mitra.orderses.entity.OrderInfo;
import com.mitra.orderses.service.OrderCommandService;
import com.mitra.orderses.service.OrderQueryService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderCommandService orderCommandService;

	@Autowired
	private OrderQueryService orderQueryService;

	@RequestMapping(method = RequestMethod.POST)
	public String orderCoffee(@Valid @RequestBody Order order) {

		final String beanOrigin = order.getBeanOrigin();
		final String coffeeType = order.getType();

		final UUID orderId = UUID.randomUUID();

		orderCommandService.placeOrder(new OrderInfo(orderId, coffeeType, beanOrigin));

		return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + orderId.toString()).build().toUriString();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{orderId}")
	public CoffeeOrder getCoffee(@Valid @PathVariable(value = "orderId") UUID orderId) {

		return orderQueryService.getOrder(orderId);
	}

}
