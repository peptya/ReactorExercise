package com.example.mono;

import reactor.core.publisher.Mono;

public class FromSupplierExample {

	public static void main(String[] args) {

		String name = "Pranit";

		Mono<String> monoString = Mono.fromSupplier(() -> name);

		monoString.subscribe(n -> System.out.println(n));
		
	}
}
