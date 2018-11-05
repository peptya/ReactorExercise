package com.bridgelabz.reactor.flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class CreateFluxFromStreamOfData {

	public static void main(String[] args) {

		// generating a source data structure
		List<String> names = Arrays.asList("Virat", "Rohit", "Gayle", "Bravo", "Dhoni", "Sachin", "Lara");

		// generating a stream of data
		Stream<String> nameStream = names.stream();

		// generating a sequence of string
		Flux<String> fluxSequence = Flux.fromStream(nameStream);
		fluxSequence.subscribe((player) -> System.out.println(player));

	}

}
