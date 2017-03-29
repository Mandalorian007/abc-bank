package com.abc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MaxiSavingsAccountTest {

    @Test
    public void testInterestWithNoWithdraws(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(100.0);
        assertEquals(50.0, maxiSavingsAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithOneWidthdraw(){
        MaxiSavingsAccount maxiSavingsAccount = new MaxiSavingsAccount();
        maxiSavingsAccount.deposit(100.0);
        maxiSavingsAccount.withdraw(5.0);
        assertEquals(0.095, maxiSavingsAccount.interestEarned(), 0.0);
    }
}
