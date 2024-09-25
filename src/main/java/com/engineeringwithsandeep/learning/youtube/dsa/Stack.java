package com.engineeringwithsandeep.learning.youtube.dsa;

public class Stack {

    Node top;
    int height;

    public Stack(int value) {
        this.top = new Node(value);
        this.height = 1;
    }

    public void printStack() {
        Node current = this.top;
        int count = 0;
        while (current != null) {
            count++;
            if (count > 1) {
                System.out.println("|");
            }
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.height != 0) {
            newNode.next = this.top;
        }
        this.top = newNode;
        this.height++;
    }

    public Node pop() {
        if (this.height == 0) return null;
        Node current = this.top;
        this.top = current.next;
        current.next = null;
        this.height--;
        return current;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class Demo {
    public static void main(String[] args) {
        Stack myStack = new Stack(5);
        myStack.push(10);
        myStack.push(20);
        myStack.printStack();
        System.out.println("Popped Node is: " + myStack.pop().value);
        myStack.printStack();
    }
}
