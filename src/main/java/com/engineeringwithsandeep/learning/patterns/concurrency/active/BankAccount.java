package com.engineeringwithsandeep.learning.patterns.concurrency.active;

public interface BankAccount {

    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
