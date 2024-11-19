package com.engineeringwithsandeep.learning.youtube.reactive.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class MyPublisherImpl implements Publisher<String> {

    @Override
    public void subscribe(Subscriber<? super String> s) {
        var subscription = new MySubscriptionImpl(s);
        s.onSubscribe(subscription);
    }
}
