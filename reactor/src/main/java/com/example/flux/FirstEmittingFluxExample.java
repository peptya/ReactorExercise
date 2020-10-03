package com.example.flux;

import reactor.core.publisher.Flux;

public class FirstEmittingFluxExample {

	public static void main(String[] args) {

		Flux<Integer> fromOneToFive = Flux.range(1, 5);
		Flux<Integer> fromSixToTen = Flux.range(6, 5);

		Flux<Integer> firstEmittingFluxSelected = Flux.first(fromSixToTen, fromOneToFive);
		firstEmittingFluxSelected.subscribe((ele) -> System.out.println(ele));
	}

}
