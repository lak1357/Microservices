package com.mitra.eventuatedemo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mitra.eventuatedemo.cmd.CreateCustomerEventCommand;
import com.mitra.eventuatedemo.cmd.EventCommand;
import com.mitra.eventuatedemo.cmd.GetCustomerEventCommand;
import com.mitra.eventuatedemo.event.CreateCustomerEvent;
import com.mitra.eventuatedemo.event.GetCustomerEvent;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

@Component
public class EventAggregate extends ReflectiveMutableCommandProcessingAggregate<EventAggregate, EventCommand> {

	public List<Event> process(CreateCustomerEventCommand command) {
		return EventUtil
				.events(new CreateCustomerEvent(command.getName(), command.getPhoneNumber(), command.getAddress()));
	}

	public void apply(CreateCustomerEvent event) {
		System.out.println(event.getName());
	}

	public List<Event> process(GetCustomerEventCommand command) {
		return EventUtil.events(new GetCustomerEvent(command.getEmail()));
	}

	public void apply(GetCustomerEvent event) {
		System.out.println(event.getEmail());
	}

}
