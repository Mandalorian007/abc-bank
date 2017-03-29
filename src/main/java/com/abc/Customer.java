package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        return accounts.stream()
                .mapToDouble(account -> account.interestEarned())
                .sum();
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account account) {
        StringBuilder s = new StringBuilder();

       //Translate to pretty account type
        switch(account.getAccountType()){
            case CHECKING:
                s.append("Checking AccountTemp\n");
                break;
            case SAVINGS:
                s.append("Savings AccountTemp\n");
                break;
            case MAXI_SAVINGS:
                s.append("Maxi Savings AccountTemp\n");
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction transaction : account.getTransactions()) {
            s.append("  ");
            s.append(transaction.getAmount() < 0 ? "withdrawal" : "deposit");
            s.append(" ");
            s.append(toDollars(transaction.getAmount()));
            s.append("\n");
            total += transaction.getAmount();
        }
        s.append("Total ");
        s.append(toDollars(total));
        return s.toString();
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
