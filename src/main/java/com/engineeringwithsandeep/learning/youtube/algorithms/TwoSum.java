package com.engineeringwithsandeep.learning.youtube.algorithms;

import java.util.Arrays;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++; // Increase the sum
            } else {
                right--; // Decrease the sum
            }
        }
        return new int[]{}; // Return empty if no pair is found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}

