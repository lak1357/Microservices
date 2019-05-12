package com.mitra.eventuatedemo.cmd;

public class CreateCustomerEventCommand implements EventCommand {

	private String name;
	private String phoneNumber;
	private String address;

	public CreateCustomerEventCommand(String name, String phoneNumber, String address) {
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
