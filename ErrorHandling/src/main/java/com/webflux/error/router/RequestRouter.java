package com.webflux.error.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.webflux.error.configuration.ParseJwtAndGetUserId;
import com.webflux.error.handler.RequestHandler;

@Configuration
public class RequestRouter {

	@Autowired
	public RequestHandler requestHandler;

	@Bean
	public RouterFunction<ServerResponse> routeRequest(RequestHandler requestHandler) {

		RouterFunction<ServerResponse> route = RouterFunctions
				.route(RequestPredicates.GET("/hello"), requestHandler::handleRequest)
				.filter(new ParseJwtAndGetUserId());
		return route;
	}

}
