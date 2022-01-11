package com.iiht.training.account.testutils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iiht.training.account.Account;

public class MasterData {

	public static Account getAccountData() {
		Account account = new Account(12345678, "Peter", 50000.00);
		return account;
	}

	public static List<Account> getAccountList() {
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account(12345678, "Peter", 50000.00);
		Account account2 = new Account(23456789, "John", 70000.00);
		Account account3 = new Account(34567890, "Leena", 65000.00);
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);

			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
