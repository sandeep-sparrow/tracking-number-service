package com.engineeringwithsandeep.learning.youtube.threading.example1;

import java.util.Date;

public class SerialMain {

    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);

        double[][] resultSerial = new double[matrix1.length][matrix2[0].length];

        Date start = new Date();
        SerialMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end = new Date();

        // Calculate the difference in milliseconds
        long durationInMillis = end.getTime() - start.getTime();

        // Convert to seconds
        double durationInSeconds = durationInMillis / 1000.0;

        // Convert to minutes
        double durationInMinutes = durationInMillis / 60000.0;

        // Print the duration in milliseconds, seconds, and minutes
        System.out.printf("Duration: %d milliseconds%n", durationInMillis);
        System.out.printf("Duration: %.2f seconds%n", durationInSeconds);
        System.out.printf("Duration: %.2f minutes%n", durationInMinutes);

        /* Normal - Non Concurrent
            Duration: 25838 milliseconds
            Duration: 25.84 seconds
            Duration: 0.43 minutes
         */
    }
}
