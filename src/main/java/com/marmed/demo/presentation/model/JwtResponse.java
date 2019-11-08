package com.marmed.demo.presentation.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = 1775392895978794064L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

}
