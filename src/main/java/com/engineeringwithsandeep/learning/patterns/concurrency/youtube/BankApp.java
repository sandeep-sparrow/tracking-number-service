package com.engineeringwithsandeep.learning.patterns.concurrency.youtube;

public class BankApp {

    public static void main(String[] args) {

        System.out.println("Bank App - Running on thread " + Thread.currentThread().getName());
        BankAccount bankAccount = new BankAccountProxy();

        new Thread(() -> bankAccount.deposit(110)).start();
        new Thread(() -> bankAccount.withdraw(20)).start();
        new Thread(() -> bankAccount.deposit(30)).start();
        new Thread(() -> bankAccount.withdraw(50)).start();

    }
}
