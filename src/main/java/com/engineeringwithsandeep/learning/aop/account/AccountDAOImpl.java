package com.engineeringwithsandeep.learning.aop.account;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private Account account;

    @Override
    public String getAccountNumber() {
        System.out.println(getClass() + ": in get accountNumber");
        return account.getAccountNumber();
    }

    @Override
    public String getAccountName() {
        System.out.println(getClass() + ": in get accountName");
        return account.getAccountName();
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        System.out.println(getClass() + ": in set accountStatus");
        account.setAccountName(accountNumber);
    }

    @Override
    public void setAccountName(String accountName) {
        System.out.println(getClass() + ": in set accountNumber");
        account.setAccountName(accountName);
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        this.account = account;
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Request incomplete internal server error!");
        }
        return List.of(
                new Account("ABCD1", "Mohan"),
                new Account("ABCD2", "Raj"),
                new Account("ABCD3", "Mike")
        );
    }
}
