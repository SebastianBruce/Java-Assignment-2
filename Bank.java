package assignment2;

import java.util.ArrayList;

public class Bank {

	private String bankName = "Scotiabank";
	private BranchLocations branchLocation = BranchLocations.ONTARIO;
	private ArrayList<Account> accounts = new ArrayList<>();

	public static enum BranchLocations {
		ONTARIO, MANITOBA, BRITISH_COLUMBIA, NOVA_SCOTIA, SASKATCHEWAN
	};
	
	public Bank() {
		accounts = new ArrayList<>();
	}
	public Bank(String bankName, String branchLocation) {
		this();
		setBankName(bankName);
		setBranchLocation(branchLocation);
	}
	public Bank(String bankName, BranchLocations branchLocation) {
		this();
		setBankName(bankName);
		setBranchLocation(branchLocation);
	}
	public String getBankName() {
		return bankName;
	}
	public boolean setBankName(String bankName) {
		if (bankName != null && bankName.matches("^(?=[a-zA-Z]*[0-9]{0,3}&* ?)[a-zA-Z0-9& ]{8,}$")) {
			this.bankName = bankName;
			return true;
		}
		return false;
	}
	public boolean setBranchLocation(String branchLocation) {
		try {
			this.branchLocation = BranchLocations.valueOf(branchLocation.toUpperCase());
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	public String getBranchLocation() {
		return branchLocation.name();
	}
			
	public boolean setBranchLocation(BranchLocations branchLocation) {
		this.branchLocation = branchLocation;
		return true;
	}
	public Account getAccountByNumber(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return new Account();
	}
	
	public boolean addAccount(Account account) {
		if (account != null && !accounts.contains(account)) {
			accounts.add(account);
			return true;
		}
		return false;
	}
	public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
		Account newAccount = new Account(accountName, accountNumber, accountBalance);
		return addAccount(newAccount);
	}
	public Account viewAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return new Account();
	}
	public Account viewAccount(byte index) {
		if (index >= 0 && index < accounts.size()) {
			return accounts.get(index);
		}
		return new Account();
	}
	public boolean modifyAccount(int accountNumber, String accountName) {
		Account accountToModify = getAccountByNumber(accountNumber);
        return accountToModify != null && accountToModify.setAccountName(accountName);
    }
	public boolean modifyAccount(int accountNumber, double accountBalance) {
		Account accountToModify = getAccountByNumber(accountNumber);
        return accountToModify != null && accountToModify.setAccountBalance(accountBalance);
    }
	public boolean modifyAccount(int accountNumber, String accountName, double accountBalance) {
		Account accountToModify = getAccountByNumber(accountNumber);
        return accountToModify != null && accountToModify.setAccountName(accountName) && accountToModify.setAccountBalance(accountBalance);
    }

	public boolean modifyAccount(byte index, String accountName) {
		if (index >= 0 && index < accounts.size()) {
			Account accountToModify = accounts.get(index);
			if (accountToModify.setAccountName(accountName)) {
				return true;
			}
		}
		return false;
	}
	public boolean modifyAccount(byte index, double accountBalance) {
		if (index >= 0 && index < accounts.size()) {
			Account accountToModify = accounts.get(index);
			return accountToModify.setAccountBalance(accountBalance);
		}
		return false;
	}

	public boolean modifyAccount(byte index, String accountName, double accountBalance) {
		if (index >= 0 && index < accounts.size()) {
			Account accountToModify = accounts.get(index);
			if (accountToModify.setAccountName(accountName) && accountToModify.setAccountBalance(accountBalance)) {
				return true;
			}
		}
		return false;
	}
	public boolean deleteAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				accounts.remove(account);
				return true;
			}
		}
		return false;
	}
	public boolean deleteAccount(byte index) {
		if (index >= 0 && index < accounts.size()) {
			accounts.remove(index);
			return true;
		}
		return false;
	}
	
	
}
