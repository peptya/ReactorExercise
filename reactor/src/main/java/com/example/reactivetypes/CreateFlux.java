package com.example.reactivetypes;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateFlux {

	public static void main(String[] args) {

		Flux<String> sequenceOne = Flux.just("Pranit", "Kokne", "Is", "A", "Awesome", "developer");
		sequenceOne.subscribe((n) -> System.out.println(n), (errorMsg) -> System.out.println("Producer falied"));

		List<String> country = Arrays.asList("India", "Pakistan", "China", "Bangladesh", "Nepal", "Bhutan");

		Flux<String> fluxCountry = Flux.fromIterable(country);

		Mono<String> noData = Mono.empty();

		Mono<String> myName = Mono.just("Pranit");

		Flux<Integer> numbersFromOneToFive = Flux.range(1, 5);
		numbersFromOneToFive.subscribe((number) -> System.out.println(number));

	}

}
