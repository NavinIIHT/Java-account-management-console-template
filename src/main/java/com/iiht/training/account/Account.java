package com.iiht.training.account;

import java.util.Objects;

public class Account implements Comparable<Account> {
	public int accNo;
	public String name;
	public double balance;

	public Account() {
	}

	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("Account [accNo=%s, name=%s, balance=%s]", accNo, name, balance);
	}

	@Override
	public int compareTo(Account account) {

		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accNo == other.accNo;
	}

}