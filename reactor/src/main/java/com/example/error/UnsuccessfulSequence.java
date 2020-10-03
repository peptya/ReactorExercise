package com.example.error;

import reactor.core.publisher.Flux;

public class UnsuccessfulSequence {

	public static void main(String[] args) {

		Flux<Integer> oneToFive = Flux.range(1, 5);
		Flux<Integer> unsuccessfulSequence = Flux.concat(oneToFive, Flux.error(() -> new NumberFormatException()));
		unsuccessfulSequence.subscribe(num -> System.out.println(num), error -> System.out.println(error));

	}

}
