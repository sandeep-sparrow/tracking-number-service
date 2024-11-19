package com.engineeringwithsandeep.learning.youtube.reactive.publisher;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Log4j2
public class MySubscriptionImpl implements Subscription {

    private final Subscriber<? super String> subscriber;
    private static final int MAX_ITEMS = 10;
    private boolean isCancelled;
    private final Faker faker;
    private int count = 0;

    public MySubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long request) {
        if(isCancelled) return;
        log.info("Requesting {}", request + " bytes");
        for(int i = 0; i < request && count < MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count == MAX_ITEMS) {
            log.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Cancelling subscription");
        this.isCancelled = true;
    }
}
