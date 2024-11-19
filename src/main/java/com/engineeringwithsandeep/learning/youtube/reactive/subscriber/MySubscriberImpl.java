package com.engineeringwithsandeep.learning.youtube.reactive.subscriber;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Log4j2
@Getter
public class MySubscriberImpl implements Subscriber<String> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
    }

    @Override
    public void onNext(String email) {
        log.info("received email: {}", email);
    }

    @Override
    public void onError(Throwable t) {
        log.error("error", t);
    }

    @Override
    public void onComplete() {
        log.info("completed!");
    }
}