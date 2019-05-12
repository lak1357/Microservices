package com.mitra.eventuatedemo.event;

import io.eventuate.Event;

public class GetCustomerEvent implements Event {

	private String email;

	public GetCustomerEvent(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
