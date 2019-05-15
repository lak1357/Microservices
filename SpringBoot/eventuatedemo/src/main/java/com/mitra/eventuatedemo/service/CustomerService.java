package com.mitra.eventuatedemo.service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import com.google.common.collect.ImmutableMap;
import com.mitra.eventuatedemo.EventAggregate;
import com.mitra.eventuatedemo.cmd.CreateCustomerEventCommand;
import com.mitra.eventuatedemo.cmd.EventCommand;
import com.mitra.eventuatedemo.model.Customer;

import io.eventuate.AggregateRepository;
import io.eventuate.SaveOptions;

public class CustomerService {

	private AggregateRepository<EventAggregate, EventCommand> aggregateRepository;

	public CustomerService(AggregateRepository<EventAggregate, EventCommand> aggregateRepository) {
		this.aggregateRepository = aggregateRepository;
	}

	public String createCustomer(Customer customer) {

		try {
			return aggregateRepository
					.save(new CreateCustomerEventCommand(customer.getName(), customer.getPhoneNumber(),
							customer.getAddress()),
							Optional.of(new SaveOptions().withEventMetadata(
									ImmutableMap.of("eventTime", String.valueOf(new Date().getTime())))))
					.get().getEntityId();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return "booo";
	}

	public Customer getCustomer(String entityId) {

		try {
			return aggregateRepository.find(entityId).get().getEntity().getCustomer();

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return new Customer("", "", "");
	}

}
