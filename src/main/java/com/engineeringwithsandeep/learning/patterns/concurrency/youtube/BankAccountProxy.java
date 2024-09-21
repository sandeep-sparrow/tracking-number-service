package com.engineeringwithsandeep.learning.patterns.concurrency.youtube;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BankAccountProxy implements BankAccount {

    private BankAccountServant servant = new BankAccountServant();
    private BlockingQueue<Runnable> requests = new LinkedBlockingQueue<>();

    public BankAccountProxy() {
        System.out.println("Bank account proxy created running on thread " + Thread.currentThread().getName());
        new Thread(this::processRequest).start();
    }

    public void processRequest() {
        try {
            do {
                System.out.println("Processing request on thread " + Thread.currentThread().getName());
                Runnable runnable = requests.take();
                runnable.run();
            } while (!requests.isEmpty());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing " + amount + " to the bank account proxy on the thread " + Thread.currentThread().getName());
        requests.add(() -> servant.deposit(amount));
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing " + amount + " from the bank account proxy on the thread " + Thread.currentThread().getName());
        requests.add(() -> servant.withdraw(amount));
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
