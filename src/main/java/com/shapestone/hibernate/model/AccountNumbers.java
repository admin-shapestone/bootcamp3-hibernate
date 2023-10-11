package com.shapestone.hibernate.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class AccountNumbers {
	@Id
	@Column(name="account_Number")
	private long accountNumber;
	@Column(name="account_Type")
	private String accountType;
	@Column(name="balance")
	private double balance;	
	@Column(name="first_Name")
	private String firstName;
	@Column(name="last_Name")
	private String lastName;
	@Column(name="account_CreationDate")
	private String accountCreationDate;
	@Column(name="address")
	private String address;
	public AccountNumbers() {}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="account_number")
	private List<Payments>paymentList;
	public List<Payments> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payments> paymentList) {
		this.paymentList = paymentList;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(String accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	@Override
	public String toString() {
		return "AccountNumbers [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance="
				+ balance + ", firstName=" + firstName + ", lastName=" + lastName + ", accountCreationDate="
				+ accountCreationDate + ", address=" + address + ", paymentList=" + paymentList + "]";
	}
	
	
	}
	

	