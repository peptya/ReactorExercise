package com.bridgelabz.reactor.flux;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class IntervalExample {

	public static void main(String[] args) throws InterruptedException {

		Flux.interval(Duration.ofMillis(1000)).take(10).subscribe(n -> System.out.println(n));
		Thread.sleep(10000);

	}

}
