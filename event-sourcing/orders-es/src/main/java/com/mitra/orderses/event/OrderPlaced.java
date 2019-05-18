package com.mitra.orderses.event;

import com.mitra.orderses.entity.OrderInfo;

public class OrderPlaced extends CoffeeEvent {

	private static final long serialVersionUID = 1L;

	private OrderInfo orderInfo;

	public OrderPlaced() {
		// TODO Auto-generated constructor stub
	}

	public OrderPlaced(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

}
