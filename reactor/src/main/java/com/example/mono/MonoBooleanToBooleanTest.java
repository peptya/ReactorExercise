package com.example.mono;

import reactor.core.publisher.Mono;

public class MonoBooleanToBooleanTest {

	public static void main(String[] args) {

		Mono<Boolean> yesOrNo = Mono.just(true);

		Mono<Boolean> has = yesOrNo.hasElement();

		boolean value = has.block();
		System.out.println(value);

	}

}
