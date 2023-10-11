package com.shapestone.hibernate.bankingdomain;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

public class InsertData {
	public void createAccount(Scanner scanner) {
	    
	            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	            Session session = sessionFactory.openSession();
	            System.out.println("Enter Account Number:");
	            long accountNumber = scanner.nextLong();
	            scanner.nextLine();
	            System.out.println("Enter First Name:");
	            String firstName = scanner.nextLine();
	            System.out.println("Enter Last Name:");
	            String lastName = scanner.nextLine();
	            System.out.println("Enter Account Creation Date (dd-MM-yyyy):");
	            String accountCreationDate = scanner.next();
	            System.out.println("Enter Account Type:");
	            String accountType = scanner.next();
	            System.out.println("Enter Balance:");
	            double balance = scanner.nextDouble();
	            AccountNumbers account = new AccountNumbers();
	            account.setAccountNumber(accountNumber);
	            account.setFirstName(firstName);
	            account.setLastName(lastName);
	            account.setAccountCreationDate(accountCreationDate);
	            account.setAccountType(accountType);
	            account.setBalance(balance);
	            session.beginTransaction();
	            session.save(account);
	            session.getTransaction().commit();

	            System.out.println("Account saved successfully!");
	       
	           
	       
	        }
	    }



