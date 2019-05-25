package com.turtlemint.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Reactor3Intro {

    public static void main(String[] args) {

        Flux<List<Integer>> numbers = Flux.range(5,4)
                                    .map(n -> n + 2)
                                    .filter(n -> n % 2 == 0)
                                    .buffer();

        numbers.subscribe(n -> {
            System.out.println(n);
        });


        //alternate
        Mono<List<Integer>> listOfIntegers = Flux.range(1,5).collectList();
        listOfIntegers.subscribe(list -> System.out.println(list));

        List<String> digits = Arrays.asList("1", "2" , "3");
        System.out.println(digits instanceof List);


    }

}
