package com.danielR.danielspring.jwt;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class JwtResponse implements Serializable {

	private final String jwttoken;
	private final String username;
	private final boolean isManager;

	public JwtResponse(String jwttoken, String username, boolean isManager) {
		this.jwttoken = jwttoken;
		this.username = username;
		this.isManager = isManager;
	}

}