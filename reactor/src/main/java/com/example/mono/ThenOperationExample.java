package com.example.mono;

import reactor.core.publisher.Mono;

public class ThenOperationExample {

	public static void main(String[] args) {

		Mono<Void> integerMono = Mono.just(1).then();
		integerMono.subscribe(v -> System.out.println(v));

		Mono<Integer> secondMonoValue = Mono.just(21).then(Mono.just(22));
		secondMonoValue.subscribe(v -> System.out.println(v));

	}

}
