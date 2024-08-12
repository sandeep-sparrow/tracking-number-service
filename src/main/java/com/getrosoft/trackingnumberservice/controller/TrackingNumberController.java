package com.getrosoft.trackingnumberservice.controller;

import com.getrosoft.trackingnumberservice.service.TrackingNumberGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracking")
public class TrackingNumberController {
    private final TrackingNumberGeneratorService trackingNumberGeneratorService;

    public TrackingNumberController(TrackingNumberGeneratorService trackingNumberGeneratorService) {
        this.trackingNumberGeneratorService = trackingNumberGeneratorService;
    }

    @GetMapping("/generate")
    public String generateTrackingNumber() {
        String trackingNumber = trackingNumberGeneratorService.generateTrackingNumber();
        return "Tracking Number: " + trackingNumber;
    }
}
