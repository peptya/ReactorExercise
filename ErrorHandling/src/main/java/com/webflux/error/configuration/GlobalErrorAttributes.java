package com.webflux.error.configuration;

import java.util.Map;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;
import reactor.util.Logger;
import reactor.util.Loggers;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

	Logger LOGGER = Loggers.getLogger(GlobalErrorAttributes.class);

	@Override
	public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
		Map<String, Object> map = super.getErrorAttributes(request, includeStackTrace);
		Throwable error = getError(request);
		map.put("status", determineHttpStatus(error));
		// map.put("message", map.get("message"));
		map.put("message", determineMessage(error));
		return map;
	}

	/*
	 * determineHttpStatus method of DefaultErrorAttribute is also returning the
	 * HttpStatus but it is private so we need to define our own method with the
	 * same logic.
	 * 
	 */
	private HttpStatus determineHttpStatus(Throwable error) {
		if (error instanceof ResponseStatusException) {
			return ((ResponseStatusException) error).getStatus();
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	/*
	 * the determineMessage method is overriding is not required because in the
	 * default implementation the message value is provided as it is required in the
	 * response body.
	 */

	private String determineMessage(Throwable error) {
		if (error instanceof ResponseStatusException) {
			return ((ResponseStatusException) error).getReason();
		}
		return error.getMessage();
	}

}
