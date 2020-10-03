package com.example.topicprocessor;

import org.reactivestreams.Subscription;

import reactor.core.CoreSubscriber;
import reactor.util.Logger;
import reactor.util.Loggers;

public class SubscriberOne implements CoreSubscriber<Integer> {

	Logger LOGGER = Loggers.getLogger(getClass());

	Subscription subscription;

	@Override
	public void onNext(Integer t) {
		System.out.println("One : " + t);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		LOGGER.error("ERROR WHILE PUBLISHING THE INTENGERS");
	}

	@Override
	public void onComplete() {
		LOGGER.info("RECEIVED THE ONCOMPLETE SIGNAL FROM PUBLISHER");
	}

	@Override
	public void onSubscribe(Subscription s) {
		LOGGER.info("IN THE onSubscribe of Subscriber one");
		this.subscription = s;
		this.subscription.request(1);
		LOGGER.info("REQUESTED FOR ONE ITEM");
	}
}
