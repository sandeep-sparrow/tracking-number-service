package com.engineeringwithsandeep.learning.patterns.concurrency.youtube;

public class BankAccountServant implements BankAccount{

    private double balance = 0;

    @Override
    public synchronized void deposit(double amount) {
        System.out.println("In Servant class deposit method: " + Thread.currentThread().getName());
        this.balance += amount;
        System.out.println("Deposited " + amount + ", new balance: " + balance);
    }

    @Override
    public synchronized void withdraw(double amount) {
        System.out.println("In Servant class withdraw method: " + Thread.currentThread().getName());
        if (amount < this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn " + amount + ", new balance: " + this.balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public synchronized double getBalance() {
        return this.balance;
    }
}
