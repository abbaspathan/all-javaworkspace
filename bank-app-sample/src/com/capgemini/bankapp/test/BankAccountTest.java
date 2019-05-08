package com.capgemini.bankapp.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bankapp.model.BankAccount;

public class BankAccountTest {

	private BankAccount account;

	@Before
	public void setUpname() {
		account = new BankAccount(101, "Jonh Deo", "SAVING", 35000);
	}

	@Test
	public void testBankAccountObjectCreatedWithDefaultConstructor() {
		BankAccount account = new BankAccount();
		assertNotNull(account);
	}

	@Test
	public void testBankAccountObjectCreatedWithParameterizedConstructor() {
		BankAccount account = new BankAccount(120, "john deo", "SAVING", 30000);
		assertNotNull(account);
		assertEquals(120, account.getAccountId());
		assertEquals("john deo", account.getAccountHolderName());
		assertEquals("SAVING", account.getAccountType());
		assertEquals(30000, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testBankAccountCurrentBalance() {
		assertEquals(35000, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testWithdrawWithSufficientFund() {
		account.withdraw(5000);
		assertEquals(30000, account.getAccountBalance(), 0.01);

	}

	@Test
	public void testWithdrawWithInSufficientFund() {

		account.withdraw(40000);
		assertEquals(35000, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testDeposit() {
		account.deposit(5000);
		assertEquals(40000, account.getAccountBalance(), 0.01);
	}
}
