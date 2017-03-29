package com.abc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MaxiSavingsAccountTest {

    @Test
    public void testInterestWithOneTransactionUnder1000(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(100.0);
        assertEquals(2.0, maxiSavingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithTwoTransactionsUnder1000(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(100.0);
        maxiSavingsAccount.withdraw(5.0);
        assertEquals(1.9000000000000001, maxiSavingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithOneTransactionOver1000(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(1001.0);
        assertEquals(20.05, maxiSavingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithTwoTransactionsOver1000(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(1006.0);
        maxiSavingsAccount.withdraw(5.0);
        assertEquals(20.05, maxiSavingsAccount.interestEarned(), 0.0);
    }


    @Test
    public void testInterestWithOneTransactionOver2000(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(2001.0);
        assertEquals(70.1, maxiSavingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithTwoTransactionsOver2000(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(2006.0);
        maxiSavingsAccount.withdraw(5.0);
        assertEquals(70.1, maxiSavingsAccount.interestEarned(), 0.0);
    }
}
