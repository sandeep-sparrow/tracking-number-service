package com.engineeringwithsandeep.learning.youtube.reactive.mono;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class FirstWithSignalExample {
    public static void main(String[] args) {
        Mono<String> providerA = Mono.delay(Duration.ofSeconds(1)).thenReturn("Weather data from provider A");
        Mono<String> providerB = Mono.delay(Duration.ofSeconds(2)).thenReturn("Weather data from provider B");

        Mono<String> fastestResponse = Mono.firstWithSignal(providerA, providerB);

        fastestResponse
                .doOnNext(System.out::println)
                .block();
    }
}
