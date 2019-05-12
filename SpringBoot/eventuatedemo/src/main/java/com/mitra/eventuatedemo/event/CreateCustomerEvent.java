package com.mitra.eventuatedemo.event;

import io.eventuate.Event;

public class CreateCustomerEvent implements Event {

	private String name;
	private String phoneNumber;
	private String address;

	public CreateCustomerEvent(String name, String phoneNumber, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

}
