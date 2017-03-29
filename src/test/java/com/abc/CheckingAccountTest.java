package com.abc;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CheckingAccountTest {

    @Test
    public void testInterestWithOneTransaction(){
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.deposit(100.0);
        assertEquals(0.1, checkingAccount.interestEarned(), 0.0);
    }

    @Test
    public void testInterestWithTwoTransactions(){
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.deposit(100.0);
        checkingAccount.withdraw(5.0);
        assertEquals(0.095, checkingAccount.interestEarned(), 0.0);
    }
}
