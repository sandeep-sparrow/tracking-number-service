package com.engineeringwithsandeep.learning.youtube.google;

import java.util.Random;

public class ReservoirSampling {

    // Function to perform Reservoir Sampling
    public static int[] selectKItems(int[] stream, int k) {
        int[] reservoir = new int[k];

        // Step 1: Fill the reservoir array with the first k elements
        for (int i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }

        // Step 2: Replace elements with gradually decreasing probability
        Random random = new Random();
        for (int i = k; i < stream.length; i++) {
            // Generate a random index between 0 and i
            int j = random.nextInt(i + 1);

            // If the randomly generated index is within the range of the reservoir, replace the element
            if (j < k) {
                reservoir[j] = stream[i];
            }
        }

        return reservoir;
    }

    public static void main(String[] args) {
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;  // Number of items to sample

        int[] sampledItems = selectKItems(stream, k);

        // Print the sampled items
        System.out.println("Sampled items:");
        for (int item : sampledItems) {
            System.out.print(item + " ");
        }
    }
}
