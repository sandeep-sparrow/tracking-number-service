package com.engineeringwithsandeep.learning.service;

import org.springframework.stereotype.Service;
/*
    @author: Sandeep
    @description: Generate unique tracking numbers in a scalable and distributed manner
    @idea: Use the combination of timestamp, machine identifier, sequence number
 */
@Service
public class TrackingNumberGeneratorService {
    // machineId: A unique identifier for the machine or instance where the service is running.
    // This is crucial in distributed systems to ensure that IDs generated on different machines do not collide.
    // The final keyword indicates that this value is set once (typically at initialization) and cannot be changed.
    private final long machineId;

    // sequence: A counter that increments with each ID generated within the same millisecond.
    // This helps ensure that IDs are unique even when multiple requests are made within the same millisecond.
    private long sequence = 0L;

    // lastTimestamp: Tracks the last time an ID was generated.
    // This helps in detecting if the current timestamp is the same as the previous one,
    // ensuring that the sequence is incremented or reset as needed.
    private long lastTimestamp = -1L;

    public TrackingNumberGeneratorService() {
        this.machineId = 1;
    }

    // thread-safe
    public synchronized String generateTrackingNumber() {
        long timestamp = System.currentTimeMillis();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate ID");
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & 4095;
            if (sequence == 0) {
                timestamp = waitForNextMillisecond(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // Construct the ID: timestamp + machineId + sequence with bit shift operation
        long id = ((timestamp << 22) | (machineId << 12) | sequence);

        return Long.toString(id);
    }

    private long waitForNextMillisecond(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}