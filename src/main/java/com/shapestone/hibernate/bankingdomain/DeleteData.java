package com.shapestone.hibernate.bankingdomain;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

public class DeleteData {

	public void deleteAccount(Scanner scanner) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		System.out.println("Enter the Account Number of the account you want to delete:");
		long accountNumberToDelete = scanner.nextLong();

		AccountNumbers account = session.get(AccountNumbers.class, accountNumberToDelete);

		if (account != null) {
			session.beginTransaction();
			session.delete(account);
			session.getTransaction().commit();

			System.out.println("Account deleted successfully!");
		} else {
			System.out.println("Account with Account Number " + accountNumberToDelete + " not found.");
		}

	}
}
