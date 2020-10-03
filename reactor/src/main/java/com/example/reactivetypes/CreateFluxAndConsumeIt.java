package com.example.reactivetypes;

import reactor.core.publisher.Flux;

public class CreateFluxAndConsumeIt {

	public static void main(String[] args) {

		Flux<Integer> tenNumbers = Flux.range(1, 10);

		tenNumbers.subscribe(num -> System.out.println(num));

	}

}
