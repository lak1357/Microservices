package com.mitrai.kafkaex.controller;

import javax.validation.Valid;

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
	public Response sendMessage(@Valid @RequestBody final Message message) {

		return new Response("message sent successfully");
	}

}
