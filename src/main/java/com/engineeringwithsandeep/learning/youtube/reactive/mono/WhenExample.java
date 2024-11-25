package com.engineeringwithsandeep.learning.youtube.reactive.mono;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class WhenExample {
    public static void main(String[] args) {
        // Simulate sending an email to User A
        Mono<Void> emailToUserA = Mono.delay(Duration.ofMillis(2000))
                .then(Mono.fromRunnable(() -> System.out.println("Email sent to User A")));

        // Simulate sending an email to User B
        Mono<Void> emailToUserB = Mono.delay(Duration.ofMillis(3000))
                .then(Mono.fromRunnable(() -> System.out.println("Email sent to User B")));

        // Simulate sending an email to User C
        Mono<Void> emailToUserC = Mono.delay(Duration.ofMillis(1000))
                .then(Mono.fromRunnable(() -> System.out.println("Email sent to User C")));

        // Use when() to wait for all emails to be sent
        Mono<Void> allEmailsSent = Mono.when(emailToUserA, emailToUserB, emailToUserC);

        // Block until all tasks are complete
        allEmailsSent
                .onErrorResume(e -> {
                    System.out.println("Error: " + e);
                    return Mono.empty();
                })
                .doOnTerminate(() -> System.out.println("All emails sent successfully!"))
                .block();
    }
}
