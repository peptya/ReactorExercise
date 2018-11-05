package com.bridgelabz.reactor.mono;

import reactor.core.publisher.Mono;

public class HasElementExample {

	public static void main(String[] args) {

		Mono<Integer> myRollNumber = Mono.just(51);
		Mono<Integer> emptyMono = Mono.empty();

		Mono<Boolean> isPresent = emptyMono.hasElement();

		isPresent.subscribe(value -> System.out.println(value));
	}

}
