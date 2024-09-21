package com.engineeringwithsandeep.learning.aop.traffic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TrafficFortuneController {

    private final TrafficFortuneServiceImpl trafficFortuneService;

    public TrafficFortuneController(TrafficFortuneServiceImpl trafficFortuneService) {
        this.trafficFortuneService = trafficFortuneService;
    }

    @GetMapping("/traffic/fortune")
    public void getTrafficFortune() {
        System.out.println("\nMain Program: getTrafficFortune");
        System.out.println("Calling getTrafficFortune()");
        String data = trafficFortuneService.getFortune(false);
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");
    }

    @GetMapping("/traffic/fortune/{tripWire}")
    public void getTrafficFortuneWithException(@PathVariable boolean tripWire) {
        System.out.println("\nMain Program: getTrafficFortune");
        System.out.println("Calling getTrafficFortune()");
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");
    }
}
