package com.mitra.orderses.event;

import org.springframework.context.ApplicationEvent;

public class CoffeeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public CoffeeEvent(Object source) {
		super(source);
	}

}
