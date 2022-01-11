package com.iiht.training.account.functional;

import static com.iiht.training.account.testutils.TestUtils.businessTestFile;
import static com.iiht.training.account.testutils.TestUtils.currentTest;
import static com.iiht.training.account.testutils.TestUtils.testReport;
import static com.iiht.training.account.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.iiht.training.account.Account;
import com.iiht.training.account.AccountMain;
import com.iiht.training.account.testutils.MasterData;

class AccountUnitTest {

	static AccountMain accountMain = null;
	static Account account = null;

	@BeforeAll
	public static void setUp() {
		accountMain = new AccountMain();
		account = new Account();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testAccountImplementsComparable() throws IOException {
		yakshaAssert(currentTest(), account instanceof Comparable<?> ? true : false, businessTestFile);
	}

	@Test
	public void testAccountsByNameOnFirstIndexEquality() throws IOException {
		List<Account> accounts = MasterData.getAccountList();
		List<Account> accounts2 = Arrays.asList(new Account(31234123, "Neena", 80000.00));
		List<Account> sortAccountsByName = AccountMain.sortAccountsByName(accounts, accounts2);
		List<Account> anotherList = new ArrayList<>();
		anotherList.addAll(accounts);
		anotherList.addAll(accounts2);
		Collections.sort(anotherList);
		
		yakshaAssert(currentTest(), sortAccountsByName.get(0).getName().equals(anotherList.get(0).getName()) ? true : false, businessTestFile);
	}
	
	@Test
	public void testAccountsByNameOnLastIndexEquality() throws IOException {
		List<Account> accounts = MasterData.getAccountList();
		List<Account> accounts2 = Arrays.asList(new Account(31234123, "Neena", 80000.00));
		List<Account> sortAccountsByName = AccountMain.sortAccountsByName(accounts, accounts2);
		List<Account> anotherList = new ArrayList<>();
		anotherList.addAll(accounts);
		anotherList.addAll(accounts2);
		Collections.sort(anotherList);
		
		yakshaAssert(currentTest(), sortAccountsByName.get(sortAccountsByName.size()-1).getName().equals(anotherList.get(anotherList.size()-1).getName()) ? true : false, businessTestFile);
	}

}
