package com.webflux.error.configuration;

import java.util.Map;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

	public GlobalErrorWebExceptionHandler(GlobalErrorAttributes errorAttributes, ServerCodecConfigurer codecConfigurer,
			ApplicationContext applicationContext) {
		super(errorAttributes, new ResourceProperties(), applicationContext);
		super.setMessageWriters(codecConfigurer.getWriters());
		super.setMessageReaders(codecConfigurer.getReaders());
	}

	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
	}

	public Mono<ServerResponse> renderErrorResponse(ServerRequest serverRequest) {
		Map<String, Object> errorPropertiesMap = getErrorAttributes(serverRequest, false);
		return ServerResponse.status((HttpStatus) errorPropertiesMap.get("status"))
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(errorPropertiesMap.get("message")));
	}

}
