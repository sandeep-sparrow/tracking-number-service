package com.engineeringwithsandeep.learning.youtube.patterns.concurrency.youtube;

public interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
