package com.engineeringwithsandeep.learning.youtube.reactive.mono;

import reactor.core.publisher.Mono;

public class WeatherService {
    public static void main(String[] args) {
        String cityName = "San Francisco";

        var temperatureMono = Mono.fromCallable(() -> fetchTemperature(cityName));

        temperatureMono
                .map(temp  -> "The temperature in " + cityName + " is " + temp + "°C")
                .doOnNext(System.out::println)
                .onErrorResume(e -> {
                    System.out.println("Error occurred: " + e.getMessage());
                    return Mono.just("Could not fetch the temperature. Default is 20°C");
                })
                .subscribe(System.out::println);
    }

    private static Double fetchTemperature(String city) {
        if(city.equals("San Francisco")) {
            throw new RuntimeException("API Service is down");
        }
        return 22.5;
    }
}
