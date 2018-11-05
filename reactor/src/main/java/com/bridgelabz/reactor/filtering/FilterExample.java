package com.bridgelabz.reactor.filtering;

import reactor.core.publisher.Flux;

public class FilterExample {

	public static void main(String[] args) {

		Flux<Integer> tenNumbers = Flux.range(1, 10);
		
		tenNumbers.filter(num -> num % 2 == 0).subscribe(v -> System.out.println(v));
		
		
	}

}
