package com.mitra.orderses.dto;

import com.mitra.orderses.entity.OrderInfo;

public class CoffeeOrder {

	private OrderInfo orderInfo;
	private CoffeeOrderState state;

	public CoffeeOrder() {

	}

	public CoffeeOrder(OrderInfo orderInfo, CoffeeOrderState state) {
		super();
		this.orderInfo = orderInfo;
		this.state = state;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public CoffeeOrderState getState() {
		return state;
	}

	public void place(final OrderInfo orderInfo) {
		state = CoffeeOrderState.PLACED;
		this.orderInfo = orderInfo;
	}

	public void accept() {
		state = CoffeeOrderState.ACCEPTED;
	}

	public void cancel() {
		state = CoffeeOrderState.CANCELLED;
	}

	public void start() {
		state = CoffeeOrderState.STARTED;
	}

	public void finish() {
		state = CoffeeOrderState.FINISHED;
	}

	public void deliver() {
		state = CoffeeOrderState.DELIVERED;
	}

	public enum CoffeeOrderState {
		PLACED, ACCEPTED, STARTED, FINISHED, DELIVERED, CANCELLED
	}

}
