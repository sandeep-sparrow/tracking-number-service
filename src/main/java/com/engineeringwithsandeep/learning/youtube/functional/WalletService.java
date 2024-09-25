package com.engineeringwithsandeep.learning.youtube.functional;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class WalletService implements Callable<Double> {
    private String walletAddress;

    public WalletService(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public Double call() throws Exception {
        // simulating a delay in fetching the balance
        TimeUnit.SECONDS.sleep(5);
        return Math.random() * 1000;
    }
}
