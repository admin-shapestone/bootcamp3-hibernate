package com.shapestone.hibernate.bankingdomain;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Payments;
import com.shapestone.hibernate.util.HibernateUtil;

public class PaymentsOfAccountHolder {

	public void printPaymentsByAccountHolder() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the account holder name space between firstname and lastName :");
		String accountHolder = scanner.nextLine();
		String hql = "SELECT p " + "FROM Payments p " + "JOIN p.accountNumbers a "
				+ "WHERE CONCAT(a.firstName, ' ', a.lastName) = :accountHolderName";

		Query<Payments> query = session.createQuery(hql, Payments.class);
		query.setParameter("accountHolderName", accountHolder);

		List<Payments> payments = query.getResultList();

		System.out.println("*----------------------*----------------*----------*----------*-------------------*");
		System.out.println("| Account Number       | Payment Details| Credits  | Debits   | Payment Category  |");
		System.out.println("*----------------------*----------------*----------*----------*-------------------*");

		for (Payments payment : payments) {
			System.out.printf("| %-20d | %-15s| %-8s | %-8s | %-16s  |\n", payment.getAccountNumber(),
					payment.getPaymentId(), payment.getCredits(), payment.getDebits(), payment.getPaymentCategory());
		}

		System.out.println("*----------------------*----------------*----------*----------*-------------------*");
		session.close();
	}

}
