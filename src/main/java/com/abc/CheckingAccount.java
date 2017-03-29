package com.abc;

public class CheckingAccount extends Account {
    double interestEarned() {
        return sumTransactions() * 0.001;
    }

    AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
