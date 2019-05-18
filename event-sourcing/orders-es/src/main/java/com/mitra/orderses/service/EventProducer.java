package com.mitra.orderses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mitra.orderses.event.CoffeeEvent;
import com.mitra.orderses.event.OrderPlaced;

@Service
public class EventProducer {

	@Autowired
	private KafkaTemplate<String, CoffeeEvent> kafkaTemplate;

	@Value("${kafka.topic.order}")
	private String orderTopic;

	public void publish(OrderPlaced orderPlaced) {
		kafkaTemplate.send(orderTopic, orderPlaced);
	}

}
