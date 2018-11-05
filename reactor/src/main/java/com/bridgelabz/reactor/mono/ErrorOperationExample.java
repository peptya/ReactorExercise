package com.bridgelabz.reactor.mono;

import reactor.core.publisher.Mono;

public class ErrorOperationExample {

	public static void main(String[] args) {

		Mono<Integer> demo = Mono.error(new ArithmeticException());
		demo.subscribe(v -> System.out.println(v), e -> System.out.println(e));

	}

}
