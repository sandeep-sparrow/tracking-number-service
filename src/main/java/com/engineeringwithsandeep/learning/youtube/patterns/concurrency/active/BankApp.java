package com.engineeringwithsandeep.learning.youtube.patterns.concurrency.active;

public class BankApp {
    public static void main(String[] args) {
        System.out.println("Application started on thread " + Thread.currentThread().getName());
        BankAccount account = new BankAccountProxy();

        // Simulate multiple clients depositing and withdrawing
        new Thread(() -> account.deposit(100)).start();
        new Thread(() -> account.withdraw(50)).start();
        new Thread(() -> account.deposit(200)).start();
        new Thread(() -> account.withdraw(150)).start();
    }
}
