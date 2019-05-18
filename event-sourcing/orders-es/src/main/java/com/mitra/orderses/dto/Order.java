package com.mitra.orderses.dto;

import javax.validation.constraints.NotEmpty;

public class Order {

	@NotEmpty(message = "type cannot be missing or empty")
	private String type;
	@NotEmpty(message = "beanOrigin cannot be missing or empty")
	private String beanOrigin;

	public Order() {

	}

	public Order(String type, String beanOrigin) {
		super();
		this.type = type;
		this.beanOrigin = beanOrigin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBeanOrigin() {
		return beanOrigin;
	}

	public void setBeanOrigin(String beanOrigin) {
		this.beanOrigin = beanOrigin;
	}

}
