package com.engineeringwithsandeep.learning.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RevenueCalculation {
    public static void main(String[] args) {
        List<Double> orderAmounts = Arrays.asList(250.0, 150.5, 300.75, 100.0, 50.25);

        double totalRevenue = orderAmounts.stream().reduce(0.0, Double::sum);

        double factorial = IntStream.rangeClosed(1, 5)
                        .reduce(1, (a, b) -> a * b);

        System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
        System.out.printf("Factorial of 5: %.2f%n", factorial);
    }
}
