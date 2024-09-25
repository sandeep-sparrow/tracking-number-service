package com.engineeringwithsandeep.learning.youtube.patterns.concurrency.active;

public class BankAccountServant implements BankAccount{
    private double balance = 0.0;

    @Override
    public synchronized void deposit(double amount) {
        System.out.println("Entered deposit() method of active class:" + Thread.currentThread().getName());
        balance += amount;
        System.out.println("Deposited " + amount + ", new balance: " + balance);
    }

    @Override
    public synchronized void withdraw(double amount) {
        System.out.println("Entered withdraw() method of active class:" + Thread.currentThread().getName());
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", new balance: " + balance);
        } else {
            System.out.println("Insufficient balance to withdraw " + amount);
        }
    }

    @Override
    public synchronized double getBalance() {
        System.out.println("Entered getBalance method of active class:" + Thread.currentThread().getName());
        return balance;
    }
}
