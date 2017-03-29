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
                .mapToDouble(Account::interestEarned)
                .sum();
    }

    public void transfer(Account from, Account to, double amount) {
        //ensure customer can only transfer between their own accounts
        if(!accounts.contains(from) || !accounts.contains(to)) {
            throw new IllegalArgumentException("You can only transfer money between 2 accounts you own.");
        }
        from.withdraw(amount);
        to.deposit(amount);
    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Statement for ");
        statement.append(name);
        statement.append("\n");
        double total = 0.0;
        for (Account a : accounts) {
            statement.append("\n");
            statement.append(statementForAccount(a));
            statement.append("\n");
            total += a.sumTransactions();
        }
        statement.append("\nTotal In All Accounts ");
        statement.append(toDollars(total));
        return statement.toString();
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

    public List<Account> getAccounts() {
        return accounts;
    }
}
