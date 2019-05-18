package com.mitra.orderses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mitra.orderses.event.CoffeeEvent;
import com.mitra.orderses.event.OrderPlaced;

@Service
public class EventProducer {

	@Autowired
	private KafkaTemplate<String, CoffeeEvent> eventKafkaTemplate;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Value("${kafka.topic.order}")
	private String orderTopic;

	public void publish(OrderPlaced orderPlaced) {
		eventKafkaTemplate.send(orderTopic, orderPlaced);
		applicationEventPublisher.publishEvent(orderPlaced);
	}

}
