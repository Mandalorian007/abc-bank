package com.abc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SavingsAccountTest {

    @Test
    public void testInterestWithOneTransactionUnder1000(){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(100.0);
        assertEquals(0.1, savingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithTwoTransactionsUnder1000(){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(100.0);
        savingsAccount.withdraw(5.0);
        assertEquals(0.095, savingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithOneTransactionOver1000(){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(10000.0);
        assertEquals(19.0, savingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithTwoTransactionsOver1000(){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(10000.0);
        savingsAccount.withdraw(5.0);
        assertEquals(18.990000000000002, savingsAccount.interestEarned(), 0.0);
    }
}
