package com.mitra.eventuatedemo.cmd;

public class GetCustomerEventCommand implements EventCommand {

	private String email;

	public GetCustomerEventCommand(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
