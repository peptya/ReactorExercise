package com.example.reactivetypes;

import reactor.core.publisher.Flux;

public class SubscribeFour {

	public static void main(String[] args) {

		Flux<Integer> numbers = Flux.range(1, 5);

		numbers.subscribe((num) -> System.out.println(num), (error) -> System.err.println(error),
				() -> System.out.println("Done"));
	}

}
