package assignment2;

import java.util.Objects;

public class Account {

	private int accountNumber;
	private double accountBalance;
	private String accountName;
	public Account() {
		this.accountNumber = 10000;
		this.accountBalance = 0.00;
		this.accountName = "Default Account";
	}
	public Account(String accountName, int accountNumber, double accountBalance) {
		setAccountName(accountName);
		setAccountNumber(accountNumber);
		setAccountBalance(accountBalance);
	}
	public String getAccountName() {
		return accountName;
	}
	public boolean setAccountName(String accountName) {
		if (accountName != null && accountName.matches("[a-zA-Z'-]+( [a-zA-Z'-]+)?") && accountName.length() >= 4) {
			this.accountName = accountName;
			return true;
		};
		return false;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public boolean setAccountNumber(int accountNumber) {
		if (String.valueOf(accountNumber).matches("\\d{5,9}")) {
			this.accountNumber = accountNumber;
			return true;
		};
		return false;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public boolean setAccountBalance(double value) {
		if (value >= 0 && String.format("%.2f", value).matches("-?\\d+(\\.\\d{1,2})?")) {
			this.accountBalance = value;
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Account account = (Account) obj;
		return accountNumber == account.accountNumber &&
				Double.compare(account.accountBalance, accountBalance) == 0 &&
				Objects.equals(accountName, account.accountName);
	}
	@Override
	public String toString() {
		return "Account:" +
				"accountNumber = " + accountNumber +
				", accountBalance = " + accountBalance +
				", accountName = '" + accountName + '\'';
	}
}

