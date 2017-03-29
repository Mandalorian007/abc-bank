package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void testApp(){
        Account checkingAccountTemp = new CheckingAccount();
        Account savingsAccountTemp = new SavingsAccount();

        Customer henry = new Customer("Henry");
        henry.openAccount(checkingAccountTemp);
        henry.openAccount(savingsAccountTemp);

        checkingAccountTemp.deposit(100.0);
        savingsAccountTemp.deposit(4000.0);
        savingsAccountTemp.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking AccountTemp\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings AccountTemp\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(new SavingsAccount());
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(new SavingsAccount());
        oscar.openAccount(new CheckingAccount());
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test
    public void testThreeAccounts() {
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(new SavingsAccount());
        oscar.openAccount(new CheckingAccount());
        oscar.openAccount(new MaxiSavingsAccount());
        assertEquals(3, oscar.getNumberOfAccounts());
    }

    @Test
    public void testInterestEarned() {
        Customer oscar = new Customer("Oscar");
        SavingsAccount savingsAccount = new SavingsAccount();
        oscar.openAccount(savingsAccount);
        CheckingAccount checkingAccount = new CheckingAccount();
        oscar.openAccount(checkingAccount);
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        oscar.openAccount(maxiSavingsAccount);

        savingsAccount.deposit(100.0);
        checkingAccount.deposit(500.0);
        maxiSavingsAccount.deposit(1000.0);

        assertEquals(500.6, oscar.totalInterestEarned(), 0);
    }

    @Test
    public void testAccountBalanceTransfer() {
        Customer oscar = new Customer("Oscar");
        SavingsAccount savingsAccount = new SavingsAccount();
        oscar.openAccount(savingsAccount);
        CheckingAccount checkingAccount = new CheckingAccount();
        oscar.openAccount(checkingAccount);

        savingsAccount.deposit(100.0);
        checkingAccount.deposit(100.0);

        oscar.transfer(savingsAccount, checkingAccount, 50.0);

        assertEquals(50.0, savingsAccount.sumTransactions(), 0.0);
        assertEquals(150.0, checkingAccount.sumTransactions(), 0.0);

    }
}
