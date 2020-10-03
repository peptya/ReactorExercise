package com.example.mono;

import reactor.core.publisher.Mono;

public class Demo {

	public static void main(String[] args) {

		
	}

	public static Mono<Integer> doSomething(int i) {
		return Mono.just(i);
	}

}
