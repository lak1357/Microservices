package com.mitra.eventuatedemo.eventhandler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitra.eventuatedemo.event.CreateCustomerEvent;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import io.eventuate.tram.messaging.producer.MessageProducer;

@EventSubscriber
public class CustomerAggregateEvents {
	@Value("${destination.consent}")
	private String destination;

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	@Autowired
	private MessageProducer messageProducer;

	@EventHandlerMethod
	public void createCustomerInitiatedEvent(DispatchedEvent<CreateCustomerEvent> event)
			throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(event.getEvent().getName());

		messageProducer.send(destination,
				MessageBuilder.withPayload(jsonString).withHeader("msgTime", SIMPLE_DATE_FORMAT.format(new Date()))
						.withHeader("operation", "linkEWallet").withHeader("CAID", event.getEvent().getName())
						.withHeader("requestId", event.getEventId().asString())
						.withHeader("aggregateId", event.getEntityId())
						.withHeader("phoneNumber", event.getEvent().getPhoneNumber()).build());
	}

}
