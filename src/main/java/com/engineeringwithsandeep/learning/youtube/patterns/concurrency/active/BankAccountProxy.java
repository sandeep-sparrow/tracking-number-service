package com.engineeringwithsandeep.learning.youtube.patterns.concurrency.active;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BankAccountProxy implements BankAccount{

    private final BankAccountServant bankAccountServant = new BankAccountServant();
    private final BlockingQueue<Runnable> requests = new LinkedBlockingQueue<>();

    public BankAccountProxy() {
        System.out.println("Entered constructor: " + Thread.currentThread().getName());
        new Thread(this::processRequests).start();
    }

    private void processRequests() {
        try {
            System.out.println("Entered processRequests() method and it has it's own thread: " + Thread.currentThread().getName());
            do {
                Runnable request = requests.take();
                request.run();
            } while (!requests.isEmpty());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Entered deposit() method of proxy class:" + Thread.currentThread().getName());
        requests.add(() -> bankAccountServant.deposit(amount));
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Entered withdraw() method of proxy class:" + Thread.currentThread().getName());
        requests.add(() -> bankAccountServant.withdraw(amount));
    }

    @Override
    public double getBalance() {
        System.out.println("Entered getBalance() method of proxy class:" + Thread.currentThread().getName());
        final double[] balance = new double[1];
        try {
            requests.add(() -> balance[0] = bankAccountServant.getBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return balance[0];
    }
}
