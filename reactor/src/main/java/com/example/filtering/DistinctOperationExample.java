package com.example.filtering;

import reactor.core.publisher.Flux;

public class DistinctOperationExample {

	public static void main(String[] args) {

		// Flux.just(1, 2, 3, 1, 2, 4, 5, 6).distinct().subscribe(v ->
		// System.out.println(v));

		// at most one element and if the source is empty get the default value
		Flux.empty().single(1).subscribe(v -> System.out.println(v));

		// at most one element and if empty i want an error
		Flux.just(1, 2, 3, 4, 5, 6, 7).single().subscribe(s -> System.out.println("success"),
				f -> System.out.println(f));

		Flux.just(1, "Pranit", true, false, 1.0).ofType(Number.class).subscribe(v -> System.out.println(v));

		System.out.println("-----------------------");
		// Flux.range(1, 100).take(30).subscribe(v -> System.out.println(v));
		// Flux.range(1, 100).next().subscribe(v -> System.out.println(v));
		Flux.range(1, 100).limitRequest(15).subscribe(v -> System.out.println(v));

	}

}
