package com.iiht.training.account.boundary;

import static com.iiht.training.account.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.account.testutils.TestUtils.currentTest;
import static com.iiht.training.account.testutils.TestUtils.testReport;
import static com.iiht.training.account.testutils.TestUtils.yakshaAssert;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.account.Account;
import com.iiht.training.account.AccountMain;
import com.iiht.training.account.testutils.MasterData;
import com.iiht.training.exception.InvalidAccountNumberException;
import com.iiht.training.exception.InvalidBalanceException;
import com.iiht.training.exception.NameCannotBeNullException;

public class BoundaryTest {

	static AccountMain accountMain = null;

	@BeforeAll
	public static void setUp() {
		accountMain = new AccountMain();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAccountNumberIsEightDigits() throws Exception {
		List<Account> accounts1 = MasterData.getAccountList();
		accounts1.get(0).setAccNo(12);
		List<Account> accounts2 = MasterData.getAccountList();
		try {
			AccountMain.sortAccountsByName(accounts1, accounts2);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (InvalidAccountNumberException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}

	}

	@Test
	public void testAccountNameShouldNotBeNull() throws Exception {

		List<Account> accounts1 = MasterData.getAccountList();
		accounts1.get(0).setName(null);
		List<Account> accounts2 = MasterData.getAccountList();
		try {
			AccountMain.sortAccountsByName(accounts1, accounts2);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (NameCannotBeNullException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}
	}

	@Test
	public void testAccountBalanceShouldBeMinimum10000() throws Exception {

		List<Account> accounts1 = MasterData.getAccountList();
		accounts1.get(0).setBalance(5000.00);
		List<Account> accounts2 = MasterData.getAccountList();
		try {
			AccountMain.sortAccountsByName(accounts1, accounts2);
			yakshaAssert(currentTest(), false, boundaryTestFile);
		} catch (InvalidBalanceException e) {
			yakshaAssert(currentTest(), true, boundaryTestFile);
		}
	}

}
