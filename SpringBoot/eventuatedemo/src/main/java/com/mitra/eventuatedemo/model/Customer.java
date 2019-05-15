package com.mitra.eventuatedemo.model;

public class Customer {

	private String name;
	private String phoneNumber;
	private String address;

	public Customer() {

	}

	public Customer(String name, String phoneNumber, String address) {
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
