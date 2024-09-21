package com.engineeringwithsandeep.learning.controller;

import com.engineeringwithsandeep.learning.service.TrackingNumberGeneratorService;
import org.springframework.web.bind.annotation.*;

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