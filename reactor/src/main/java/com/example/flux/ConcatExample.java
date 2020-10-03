package com.example.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConcatExample {

	public static void main(String[] args) {

		Flux<Integer> fromOneToFive = Flux.range(1, 5);
		Flux<Integer> fromSixToTen = Flux.range(6, 5);
		Mono<Integer> justOneNumber = Mono.just(11);
		Flux<Integer> concatedFlux = Flux.concat(fromOneToFive, fromSixToTen, justOneNumber);
		concatedFlux.subscribe((number) -> System.out.println(number));

	}

}
