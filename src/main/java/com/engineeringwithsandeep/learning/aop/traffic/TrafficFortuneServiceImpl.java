package com.engineeringwithsandeep.learning.aop.traffic;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune(boolean tripWire) {
        // simulate a delay
        if (tripWire) {
            throw new RuntimeException("Trip wires are not supported, Internal Server error!");
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        // return a fortune
        return "Expect heavy traffic this morning!";
    }
}
