package com.engineeringwithsandeep.learning.youtube.reactive;

import com.engineeringwithsandeep.learning.youtube.reactive.publisher.MyPublisherImpl;
import com.engineeringwithsandeep.learning.youtube.reactive.subscriber.MySubscriberImpl;


public class Demo {

    public static void main(String[] args) throws InterruptedException {
        demo1();
        demo2();
    }

    private static void demo1() {
        var publisher = new MyPublisherImpl();
        var subscriber = new MySubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2() throws InterruptedException {
        var publisher = new MyPublisherImpl();
        var subscriber = new MySubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
        Thread.sleep(2000);
        subscriber.getSubscription().request(3);
    }
}
