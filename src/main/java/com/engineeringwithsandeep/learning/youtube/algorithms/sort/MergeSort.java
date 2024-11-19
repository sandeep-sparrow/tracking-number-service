package com.engineeringwithsandeep.learning.youtube.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10};
        int[] b = {1, 3, 5, 7, 9};

        int[] result = merge(a, b);
        int[] array = {1, 4, 6, 3, 8, 2, 9, 10, 5, 7};
        int[] sortedArray = mergesort(array);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] mergesort(int[] array) {
        if (array.length == 1) return array;
        int midIndex = array.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergesort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0;
        int index = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[index++] = a[i++];
            } else {
                result[index++] = b[j++];
            }
        }
        while (i < a.length) {
            result[index++] = a[i++];
        }
        while (j < b.length) {
            result[index++] = b[j++];
        }
        return result;
    }
}
