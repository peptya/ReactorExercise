package com.example.flux;

import reactor.core.publisher.Flux;

public class FlatMapExample {

	public static void main(String[] args) {

		Flux<String> names = Flux.just("pranit", "swapnil", "jaspreet");

		// names.map(name -> name).subscribe(n -> System.out.println(n));

		Flux<String> mName = names.flatMap(name -> Flux.just(name.split("")));
		mName.subscribe(n -> System.out.println(n));

		// Mono<List<String>> nameList = names.collectList();
		//
		// nameList.subscribe(list -> System.out.println(list));

	}

}
