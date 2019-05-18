package com.mitra.baristaes.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mitra.orderses.event.CoffeeEvent;

@Service
public class EventConsumer {

	@KafkaListener(topics = "order", groupId = "group_id")
	public void order(CoffeeEvent coffeeEvent) {
		System.out.println("tttttt");
	}

}
