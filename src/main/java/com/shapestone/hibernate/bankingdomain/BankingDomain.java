package com.shapestone.hibernate.bankingdomain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.model.Payments;
import com.shapestone.hibernate.util.HibernateUtil;
public class BankingDomain {
	public static void main(String[] args) {
		boolean wannaContinue = true;
		Scanner scanner = new Scanner(System.in);
		dumpData();
		while (wannaContinue) {
			System.err.println("WELCOME TO THE BANKING @....");
			System.out.println("Select any option from below menu....");
			System.out.println("1-> fetch and display data");
			System.out.println("2->insert data");
			System.out.println("3->update data");
			System.out.println("4->delete data");
			System.out.println("5->fetchData and Display using criteria");
			System.out.println("6->print all Accounts");
			System.out.println("7->print all acounts sorted by name");
			System.out.println("8->print all accounts created today and yesterday");
			System.out.println("9->print all payments done by account holder");
			System.out.println("10->print all balance of the account holder");
			int option = scanner.nextInt();
			//scanner.nextLine();
			if (option == 1) {
				DataRetrive dataRetrieveCreativeNativeQuery = new DataRetrive();
				dataRetrieveCreativeNativeQuery.fetchDataAndDisplayAccounts();
			} else if (option == 2) {
				InsertData insertData = new InsertData();
				insertData.createAccount(scanner);
			} else if (option == 3) {
				UpdateData updateData = new UpdateData();
				updateData.updateName(scanner);
			} else if (option == 4) {
				DeleteData deleteData = new DeleteData();
				deleteData.deleteAccount(scanner);
			} else if (option == 5) {
				DataRetrieve dataRetrieve = new DataRetrieve();
				dataRetrieve.fetchDataAndDisplayAccounts();
				dataRetrieve.fetchDataAndDisplayPayments();
			} else if (option == 6) {
				PrintAllAccountNumbers account = new PrintAllAccountNumbers();
				account.dispalyAccountNUmbers();
			} else if (option == 7) {
				PrintAllAccountNumbersSortedByName sortedByName = new PrintAllAccountNumbersSortedByName();
				sortedByName.accountsSorted();
			} else if (option == 8) {
				CreatedTodayYesterday accounts = new CreatedTodayYesterday();
				accounts.todayYesterDay();
			} else if (option == 9) {
				PaymentsOfAccountHolder payments = new PaymentsOfAccountHolder();
				payments.printPaymentsByAccountHolder();

			} else if (option == 10) {
				Balance balance = new Balance();
				balance.totalBalance();
			} else {
				System.out.println("you have choosen wrong option...");
			}
			System.out.println("do you want to continue.....");
			String continueCheck = scanner.next();
			if (!continueCheck.equalsIgnoreCase("yes")) {
				wannaContinue = false;
			}
		}
	}

	private static void dumpData() {
		ObjectMapper mapper = new ObjectMapper();
		AccountNumbers[] accountNumbers = null;
		Payments[] paymentsData = null;
		try {
			accountNumbers = mapper.readValue(new File("Account.json"), AccountNumbers[].class);
			paymentsData = mapper.readValue(new File("Payment.json"), Payments[].class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		for (AccountNumbers accountData : accountNumbers) {
			List<Payments> addPaymentstoAccount = addPaymentstoAccount(accountData, paymentsData);
			accountData.setPaymentList(addPaymentstoAccount);
			openSession.persist(accountData);
		}
		beginTransaction.commit();
	}

	private static List<Payments> addPaymentstoAccount(AccountNumbers accountData, Payments[] paymentsData) {
		List<Payments> payments = new ArrayList<>();
		for (Payments payment : paymentsData) {
			if (accountData.getAccountNumber() == payment.getAccountNumber()) {
				payments.add(payment);
			}
		}

		return payments;
	}

}