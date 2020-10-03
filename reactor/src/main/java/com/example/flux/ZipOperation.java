package com.example.flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import reactor.core.publisher.Flux;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.function.Tuple2;

public class ZipOperation {

	public static void main(String[] args) throws InterruptedException {

		final Logger log = Loggers.getLogger(ZipOperation.class);

		Flux<String> names = Flux.just("Pranit", "Swapnil", "Jaspreet");
		Flux<Integer> age = Flux.just(22, 24, 23);

		Flux<Tuple2<String, Integer>> combination = Flux.zip(names, age);

		// combination.subscribe(v -> log.info("Pair : {}", v));

		Flux<Integer> nameAndAgeAddition = Flux.zip(names, age, (n, a) -> {
			return n.length() + a;
		});

		// nameAndAgeAddition.subscribe(v -> log.info("Addition : {}", v));

		Flux<Long> firstSequence = Flux.interval(Duration.ofMillis(1000)).take(10);
		Flux<Long> lastSequence = Flux.interval(Duration.ofMillis(1000)).take(15);

		Flux.zip(firstSequence, lastSequence).subscribe(pair -> log.info("Pair : {}", pair),
				e -> log.error(e.getMessage()));

		TimeUnit.SECONDS.sleep(2);

	}

}
