package com.mitra.orderses.entity;

import java.util.UUID;

public class OrderInfo {

	private UUID orderId;
	private String type;
	private String beanOrigin;

	public OrderInfo() {

	}

	public OrderInfo(final UUID orderId, final String type, final String beanOrigin) {
		this.orderId = orderId;
		this.type = type;
		this.beanOrigin = beanOrigin;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public String getType() {
		return type;
	}

	public String getBeanOrigin() {
		return beanOrigin;
	}

}
