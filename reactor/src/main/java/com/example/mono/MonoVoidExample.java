package com.example.mono;

import reactor.core.publisher.Mono;

public class MonoVoidExample {

	public static void main(String[] args) {

		Mono<Void> isVoid = Mono.justOrEmpty(null);

		isVoid.hasElement().subscribe(v -> System.out.println(v));
		
		
	}

}
