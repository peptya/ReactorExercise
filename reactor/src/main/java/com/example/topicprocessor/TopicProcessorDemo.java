package com.example.topicprocessor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import reactor.core.publisher.TopicProcessor;

public class TopicProcessorDemo {

	public static void main(String[] args) {

		int numberOfMessages = 1000;
		
		TopicProcessor<Integer> numberPublisher = TopicProcessor.create();
		
		SubscriberOne one = new SubscriberOne();
		numberPublisher.subscribe(one);
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		AtomicInteger counter = new AtomicInteger(0);
		for (int i = 0; i < numberOfMessages; i++) {
			executorService.submit(() -> {
				numberPublisher.onNext(counter.incrementAndGet());
			});
		}
	}

}
