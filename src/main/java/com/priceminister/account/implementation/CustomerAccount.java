package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    /**
     * the current account balance.(0 by default when created)
     * Auto-inboxing
     */
    private Double balance = 0.0d;


    public void add(Double addedAmount) {
        balance += addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
        double newBalance =balance - withdrawnAmount;
        if(!rule.withdrawPermitted(newBalance))
            throw new IllegalBalanceException(newBalance);
        balance = newBalance;
        return balance;
    }

}
