package com.engineeringwithsandeep.learning.youtube.patterns.concurrency.active;

public interface BankAccount {

    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
