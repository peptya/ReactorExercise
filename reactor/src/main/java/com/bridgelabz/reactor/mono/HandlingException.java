package com.bridgelabz.reactor.mono;

import java.io.IOException;

import reactor.core.publisher.Mono;

public class HandlingException {

	public static void main(String[] args) {

		Mono<Object> luckyNumber = Mono.error(new ArithmeticException()).onErrorResume((error) -> Mono.just(10 / 2));
		luckyNumber.subscribe(v -> System.out.println(v), error -> System.out.println(error));

		Mono<Object> defaultValue = Mono.error(new IOException()).onErrorReturn(10);
		defaultValue.subscribe(v -> System.out.println(v));

	}

}
