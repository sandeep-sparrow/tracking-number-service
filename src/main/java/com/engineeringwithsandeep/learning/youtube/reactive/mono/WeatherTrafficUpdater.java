package com.engineeringwithsandeep.learning.youtube.reactive.mono;

import reactor.core.publisher.Mono;

public class WeatherTrafficUpdater {
    public static void main(String[] args) {
        String city = "Mumbai";
        Mono<String> weatherMono = getWeatherUpdate(city);
        Mono<String> trafficMono = getTrafficUpdate(city);

        // this zip and zipWith factory method waits for both the mono's to emit their result and apply the combiner
        // and result a Mono<T>
        Mono<String> combinedUpdates = Mono
                .zip(weatherMono, trafficMono, (weather, traffic) -> "Weather: " + weather + ", Traffic: " + traffic);

        Mono<String> combinedUpdatesUsingChaining = weatherMono
                .zipWith(trafficMono, (weather, traffic) -> "Weather: " + weather + ", Traffic: " + traffic);

        combinedUpdates.subscribe((e) -> System.out.println(e));
        combinedUpdatesUsingChaining.subscribe((e) -> System.out.println(e));
    }

    private static Mono<String> getTrafficUpdate(String city) {
        // let's say this was a network call, then we can use the Mono.fromCallable(callable) method
        // and then onSubscribe(Schedulers.single()) to run the network call over a background thread
        return Mono.just("Partly Cloudy in " + city);
    }

    private static Mono<String> getWeatherUpdate(String city) {
        // let's say this was a network call, then we can use the Mono.fromCallable(callable) method
        // and then onSubscribe(Schedulers.single()) to run the network call over a background thread
        return Mono.just("Moderate traffic in " + city);
    }
}
