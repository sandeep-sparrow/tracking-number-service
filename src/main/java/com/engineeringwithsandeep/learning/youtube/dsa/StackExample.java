package com.engineeringwithsandeep.learning.youtube.dsa;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // push elements to the stacks
        stack.push(13);
        stack.push(14);
        stack.push(16);

        // peek at the top element
        System.out.println("Top Element in this Stack: " + stack.peek());

        // pop the top element
        System.out.println("Popped Element in this Stack: " + stack.pop());
        System.out.println("Top Element in this Stack: " + stack.peek());


        // check if stack is empty
        System.out.println("Is Stack empty? " + stack.isEmpty());
    }
}
