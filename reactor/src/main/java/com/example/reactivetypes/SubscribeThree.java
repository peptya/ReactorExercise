package com.example.reactivetypes;

import reactor.core.publisher.Flux;

public class SubscribeThree {

	public static void main(String[] args) {

		Flux<Integer> numbers = Flux.range(1, 4).map(num -> {
			if (num != 2)
				return num;
			throw new RuntimeException("Got to 2");
		});

		numbers.subscribe(i -> System.out.println(i), error -> System.out.println(error));
	}

}
