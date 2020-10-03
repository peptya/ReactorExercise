package com.example.flux;

import reactor.core.publisher.Flux;

public class MapExample {

	// a synchronous function
	public static String makeUpperCase(String name) {
		System.out.println("value : " + name);
		return name.toUpperCase();
	}

	public static void main(String[] args) {

		Flux<String> names = Flux.just("pranit", "kokne", "java", "reactjs");
		
		names.map(n -> MapExample.makeUpperCase(n))
		.subscribe((upperCaseName) -> System.out.println(upperCaseName));

	}

}
