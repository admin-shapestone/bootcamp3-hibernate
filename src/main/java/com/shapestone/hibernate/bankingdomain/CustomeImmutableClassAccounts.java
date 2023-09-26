package com.shapestone.hibernate.bankingdomain;

public final class CustomeImmutableClassAccounts {
	private final String accountname;
	private final long accountNumber;
	private final Address address;
	
	
	public CustomeImmutableClassAccounts(String accountname, long accountNumber, Address address) {
		super();
		this.accountname = accountname;
		this.accountNumber = accountNumber;
		this.address = address;
	}
	public String getAccountname() {
		return accountname;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public Address getAddress() {
		return new Address(address);
	}
	
	@Override
	public String toString() {
		return "CustomeImmutableClassAccounts [accountname=" + accountname + ", accountNumber=" + accountNumber
				+ ", address=" + address + "]";
	}
	
		

	
}
