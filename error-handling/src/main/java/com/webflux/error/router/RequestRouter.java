package com.webflux.error.router;

import com.webflux.error.configuration.ParseJwtAndGetUserId;
import com.webflux.error.handler.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

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
