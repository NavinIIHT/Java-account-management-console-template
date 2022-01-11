package com.iiht.training.account.exception;

import static com.iiht.training.account.testutils.TestUtils.currentTest;
import static com.iiht.training.account.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.account.testutils.TestUtils.testReport;
import static com.iiht.training.account.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.account.Account;
import com.iiht.training.account.AccountMain;
import com.iiht.training.account.testutils.MasterData;
import com.iiht.training.exception.AccountNumberAlreadyExistsException;

class AccountExceptionTest {

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
	public void testAccountNumberAlreadyExistsException() throws IOException {
		List<Account> list = MasterData.getAccountList();
		AccountNumberAlreadyExistsException thrown = Assertions.assertThrows(AccountNumberAlreadyExistsException.class,
				() -> {
					AccountMain.sortAccountsByName(list, list);
				});
		
		yakshaAssert(currentTest(), !thrown.getMessage().isEmpty() ? true : false, exceptionTestFile);

	}

}
