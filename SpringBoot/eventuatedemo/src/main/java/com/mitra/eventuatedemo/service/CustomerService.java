package com.mitra.eventuatedemo.service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import com.google.common.collect.ImmutableMap;
import com.mitra.eventuatedemo.EventAggregate;
import com.mitra.eventuatedemo.cmd.CreateCustomerEventCommand;
import com.mitra.eventuatedemo.cmd.EventCommand;
import com.mitra.eventuatedemo.cmd.GetCustomerEventCommand;

import io.eventuate.AggregateRepository;
import io.eventuate.SaveOptions;

public class CustomerService {

	private AggregateRepository<EventAggregate, EventCommand> aggregateRepository;

	public CustomerService(AggregateRepository<EventAggregate, EventCommand> aggregateRepository) {
		this.aggregateRepository = aggregateRepository;
	}

	public String createCustomer() {

		try {
			return aggregateRepository
					.save(new CreateCustomerEventCommand("Lakshitha", "+94661114322", "Colombo"),
							Optional.of(new SaveOptions().withEventMetadata(
									ImmutableMap.of("eventTime", String.valueOf(new Date().getTime())))))
					.get().getEntityVersion().asString();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return "booo";
	}

	public String getCustomer() {

		try {
			return aggregateRepository
					.save(new GetCustomerEventCommand("laktest@gmail.com"),
							Optional.of(new SaveOptions().withEventMetadata(
									ImmutableMap.of("eventTime", String.valueOf(new Date().getTime())))))
					.get().getEntityVersion().asString();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return "booo";
	}

}
