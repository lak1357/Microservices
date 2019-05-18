package com.mitra.orderses.event;

import com.mitra.orderses.entity.OrderInfo;

public class OrderPlaced extends CoffeeEvent {

	private OrderInfo orderInfo;

	public OrderPlaced() {

	}

	public OrderPlaced(OrderInfo orderInfo) {
		super();
		this.orderInfo = orderInfo;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

}
