package com.abc;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private final List<Transaction> transactions = new ArrayList<>();

    abstract double interestEarned();

    abstract AccountType getAccountType();

    public void deposit(double amount) {
        enforceAmountIsValid(amount);
        transactions.add(new Transaction(amount));
    }

    public void withdraw(double amount) {
        enforceAmountIsValid(amount);
        transactions.add(new Transaction(-amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void accrueDailyInterest() {
        deposit(interestEarned()/365.0);
    }

    public double sumTransactions() {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private void enforceAmountIsValid(double amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Transaction amounts must be greater than zero.");
    }
}
