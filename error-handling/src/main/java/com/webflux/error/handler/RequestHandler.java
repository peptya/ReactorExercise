package com.webflux.error.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

@Component
public class RequestHandler {

    Logger LOGGER = Loggers.getLogger(RequestHandler.class);

    public Mono<ServerResponse> handleRequest(ServerRequest serverRequest) {
        LOGGER.info(serverRequest.attribute("userId").get().toString());
        return sayHello(serverRequest).flatMap(name -> {
            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).syncBody(name);
        });
    }

    public Mono<String> sayHello(ServerRequest serverRequest) {
        return Mono.just("Hello " + serverRequest.queryParam("username").get());
    }

}
