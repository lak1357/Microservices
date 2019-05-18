package com.mitra.orderses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitra.orderses.entity.OrderInfo;
import com.mitra.orderses.event.OrderPlaced;

@Service
public class OrderCommandService {
	
	@Autowired
	private EventProducer eventProducer;

	public void placeOrder(final OrderInfo orderInfo) {
		eventProducer.publish(new OrderPlaced(orderInfo));
	}

}
