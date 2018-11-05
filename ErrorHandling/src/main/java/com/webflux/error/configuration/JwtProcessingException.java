package com.webflux.error.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class JwtProcessingException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public JwtProcessingException(HttpStatus status, String message) {
		super(status, message);
	}

}
