package com.abc;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class MaxiSavingsAccount extends Account {
    @Override
    double interestEarned() {
        double amount = sumTransactions();
        if(checkForWidthdraws()) {
            return amount * 0.001;
        } else {
            return amount * 0.5;
        }
    }

    private boolean checkForWidthdraws() {
        List<Transaction> withdrawsInPast10Days = getTransactions().stream()
                .filter(transaction -> transaction.getAmount() < 0 && transaction.getTransactionDate().after(daysAgo(10)))
                .collect(Collectors.toList());
        return withdrawsInPast10Days.size() > 0;
    }


    private static Date daysAgo(int days) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DATE, -days);
        return gc.getTime();
    }

    @Override
    AccountType getAccountType() {
        return AccountType.MAXI_SAVINGS;
    }
}
