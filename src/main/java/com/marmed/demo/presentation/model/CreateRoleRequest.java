package com.marmed.demo.presentation.model;

import java.io.Serializable;

public class CreateRoleRequest implements Serializable{
	
	private static final long serialVersionUID = -6733381547374269481L;
	
	private String name;
	
	public CreateRoleRequest() {}
	
	public CreateRoleRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
