package com.engineeringwithsandeep.learning.aop.account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    List<Account> findAccounts(boolean tripWire);

    boolean doWork();

    String getAccountNumber();

    String getAccountName();

    void setAccountNumber(String accountNumber);

    void setAccountName(String accountName);
}