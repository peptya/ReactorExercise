package com.bridgelabz.reactor.flux;

import reactor.core.publisher.Flux;

public class CreateFluxFromArray {

	public static void main(String[] args) {
		Integer[] numbers = new Integer[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i * 3;
		}

		Flux<Integer> tenNumbers = Flux.fromArray(numbers);
		tenNumbers.subscribe((n) -> System.out.println(n));
	}

}
