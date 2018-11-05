package com.bridgelabz.reactor.reactivetypes;

import reactor.core.publisher.Flux;

public class SubscribeTwo {

	public static void main(String[] args) {

		Flux<Integer> integerSequence = Flux.range(1, 10);

		integerSequence.subscribe((number) -> {
			System.out.println(number * 3);
		});

	}

}
