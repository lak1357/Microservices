package com.mitrai.kafkaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	KafkaTemplate<String, String> stringKafkaTemplate;
	private static final String TOPIC = "MyTopic1";

	@GetMapping("/publish/{message}")
	public String publishMessage(@PathVariable("message") final String message) {

		stringKafkaTemplate.send(TOPIC, message);
		return "Message Sent";

	}

}
