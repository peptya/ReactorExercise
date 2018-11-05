package com.bridgelabz.reactor.flux;

import reactor.core.publisher.Flux;

public class ReduceOperation {

	public static void main(String[] args) {

		Flux<Integer> tenNumbers = Flux.range(1, 10);
		Integer multiplicationResult = tenNumbers.reduce((intermediateResult, currentValue) -> {
			return intermediateResult * currentValue;
		}).block();

		System.out.println(multiplicationResult);

	}

}
