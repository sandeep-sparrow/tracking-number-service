package com.engineeringwithsandeep.learning.patterns.concurrency.youtube;

public interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
