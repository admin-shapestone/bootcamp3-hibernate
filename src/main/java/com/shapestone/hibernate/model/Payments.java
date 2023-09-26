package com.shapestone.hibernate.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Payments")
public class Payments {
	@Id
	String paymentId;
	
	private long accountNumber;
	private double balance;
	String currency;
	String email;
	private double credits;
	private double debits;
	String transactionDateTime;
	String paymentCategory;
	public AccountNumbers getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(AccountNumbers accountNumbers) {
	this.accountNumbers = accountNumbers;
	}

	@ManyToOne
	@JoinColumn(name="account_number")
  private AccountNumbers accountNumbers;
	public Payments() {

	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balace) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public double getDebits() {
		return debits;
	}

	public void setDebits(double debits) {
		this.debits = debits;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getPaymentCategory() {
		return paymentCategory;
	}

	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", currency=" + currency + ", email=" + email + ", credits=" + credits + ", debits=" + debits
				+ ", transactionDateTime=" + transactionDateTime + ", paymentCategory=" + paymentCategory
				+ ", accountNumbers=" + accountNumbers + "]";
	}

	

	
	

}
