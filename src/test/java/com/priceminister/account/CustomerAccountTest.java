package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        Double emptyAccountBalance = customerAccount.getBalance();
        assertNotNull("an empty account should be not Null", emptyAccountBalance);
        assertEquals("an empty account should be 0.0", 0.0d, emptyAccountBalance, 0.0d);
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        assertEquals("Initial value: Expected 0.0",
                0.0d, customerAccount.getBalance(), 0.0d);
        Double addAmount = 15.0d;
        customerAccount.add(addAmount);
        assertEquals("Adds money to the account: Expected 15.0",
                15.0d, customerAccount.getBalance(), 0.0d);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {

        try {
            customerAccount.withdrawAndReportBalance(20.0d, rule);
            fail("It should throw an exception because of an illegal withdrawal");
        } catch (IllegalBalanceException e) {
            assertEquals("Check Thrown message",
                    "Illegal account balance: -20.0", e.toString());
        }
    }


    /**
     * Test WithdrawPermitted() checks if this method works
     */
    @Test
    public void testWithdrawPermitted() {
        assertTrue("True when the value is positive", rule.withdrawPermitted(1.0d));
        assertFalse("False when the value is negative", rule.withdrawPermitted(-1.0d));
    }
    
    // Also implement missing unit tests for the above functionalities.

}
