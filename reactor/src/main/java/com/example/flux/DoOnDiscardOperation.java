package com.example.flux;

import java.util.concurrent.atomic.AtomicInteger;

import reactor.core.publisher.Flux;

public class DoOnDiscardOperation {

	public static void main(String[] args) {

		AtomicInteger discardedCount = new AtomicInteger();

		Flux.range(1, 20).filter(i -> i % 2 == 0).doOnDiscard(Number.class, i -> discardedCount.getAndIncrement())
				.subscribe(e -> System.out.println(e));

		System.out.println(discardedCount);
	}

}
