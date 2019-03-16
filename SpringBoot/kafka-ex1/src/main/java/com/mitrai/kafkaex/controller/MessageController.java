package com.mitrai.kafkaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitrai.kafkaex.dto.Message;
import com.mitrai.kafkaex.dto.Response;

@RestController("/message")
public class MessageController {

	@Autowired
	KafkaTemplate<String, Message> jsonKafkaTemplate;

	@PostMapping
	public Response sendMessage(@RequestBody final Message message) {

		if (message != null && message.getTopic() != null && message.getTopic().trim().length() > 0) {
			jsonKafkaTemplate.send(message.getTopic(), message);
		}

		return new Response("message sent successfully");

	}

}
