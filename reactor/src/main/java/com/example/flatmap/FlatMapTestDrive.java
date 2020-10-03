package com.example.flatmap;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class FlatMapTestDrive {

    public static void main(String[] args) {
        flatMap();
    }

    private static void flatMap() {
        Flux.just("a", "b", "c", "d", "e", "f", "g")
                .window(2)
                .flatMap(fluxOf2Letters -> fluxOf2Letters.map(letter -> FlatMapUtil.toUpperCase(letter)))
                .doOnNext(System.out::println)
                .blockLast();
    }

    private static void flatMapParallel() {
        Flux.just("a", "b", "c", "d", "e", "f", "g")
                .window(2)
                .flatMap(fluxOf2Letters -> fluxOf2Letters.map(letter -> FlatMapUtil.toUpperCase(letter)).subscribeOn(parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    private static void concatMap() {
        Flux.just("a", "b", "c", "d", "e", "f", "g")
                .window(2)
                .concatMap(fluxOf2Letters -> fluxOf2Letters.map(letter -> FlatMapUtil.toUpperCase(letter)).subscribeOn(parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    private static void flatMapSequential() {
        Flux.just("a", "b", "c", "d", "e", "f", "g")
                .window(2)
                .flatMapSequential(fluxOf2Letters -> fluxOf2Letters.map(letter -> FlatMapUtil.toUpperCase(letter)).subscribeOn(parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    private static Scheduler parallel() {
        return Schedulers.parallel();
    }

}
