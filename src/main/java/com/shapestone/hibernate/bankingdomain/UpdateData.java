package com.shapestone.hibernate.bankingdomain;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

public class UpdateData {

	public void updateName(Scanner scanner) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("Enter the Account Number of the account you want to update:");
        long accountNumberToUpdate = scanner.nextLong();
        scanner.nextLine();
        AccountNumbers account = session.get(AccountNumbers.class, accountNumberToUpdate);
		if (account != null) {
			System.out.println("Enter updated Last Name:");
			String updatedLastName = scanner.nextLine();
			account.setLastName(updatedLastName);
			// Begin a transaction and update the account
			session.beginTransaction();
			session.update(account);
			session.getTransaction().commit();

			System.out.println("Account updated successfully!");
		} else {
			System.out.println("Account with Account Number " + accountNumberToUpdate + " not found.");
		}

	}

}
