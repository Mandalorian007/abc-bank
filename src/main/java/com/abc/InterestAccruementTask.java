package com.abc;

public class InterestAccruementTask implements Runnable {
    private final Bank bank;

    public InterestAccruementTask(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.getCustomers().stream()
                .flatMap(customer -> customer.getAccounts().stream())
                .forEach(Account::accrueDailyInterest);
    }
}
