package com.engineeringwithsandeep.learning.youtube.algorithms.sort;

import java.util.Arrays;

public class Sorts {

    public static void bubbleSort(int[] myArray) {
        for(int i =  myArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[j + 1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] myArray) {
        for(int i = 1; i < myArray.length; i++) {
            int temp = myArray[i];
            int j = i - 1;
            while (j > -1 && temp < myArray[j]) {
                myArray[j + 1] = myArray[j];
                myArray[j] = temp;
                j = j - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};
        bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
