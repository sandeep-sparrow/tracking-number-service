package com.engineeringwithsandeep.learning.youtube.dsa.arraylist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Initialization with 1 type of element only
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(numbers);
        System.out.println(numbers.size());

        // Insertion - allows duplicate, insertion order
        numbers.add(2);
        System.out.println(numbers);
        System.out.println(numbers.size());

        // Insert at index
        numbers.add(4, 10);
        System.out.println(numbers);
        System.out.println(numbers.size());

        // Access by Index
        System.out.println(numbers.get(4));

        // Traversal - O(n)
        for(Integer number : numbers) {
            System.out.println(number);
        }

        // Traversal using iterator
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Reverse array
        int[] input = {1, 2, 3, 4, 5};
        reverse(input);
    }

    static void reverse(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            int other = array.length - 1 - i;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
