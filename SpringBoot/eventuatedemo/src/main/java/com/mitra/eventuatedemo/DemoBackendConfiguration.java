package com.mitra.eventuatedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mitra.eventuatedemo.cmd.EventCommand;
import com.mitra.eventuatedemo.eventhandler.CustomerAggregateEvents;
import com.mitra.eventuatedemo.service.CustomerService;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;

@Configuration
@Import({ EventuateDriverConfiguration.class })
@EnableEventHandlers
public class DemoBackendConfiguration {

	@Bean
	public AggregateRepository<EventAggregate, EventCommand> aggregateRepository(EventuateAggregateStore eventStore) {
		return new AggregateRepository<>(EventAggregate.class, eventStore);
	}

	@Bean
	public CustomerService customerService(AggregateRepository<EventAggregate, EventCommand> aggregateRepository) {
		return new CustomerService(aggregateRepository);
	}

	@Bean
	public CustomerAggregateEvents customerAggregateEvents() {
		return new CustomerAggregateEvents();
	}
}
