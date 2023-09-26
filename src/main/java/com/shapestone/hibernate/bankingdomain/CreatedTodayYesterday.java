package com.shapestone.hibernate.bankingdomain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

public class CreatedTodayYesterday {

	public void todayYesterDay() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);

		String hql = "FROM AccountNumbers WHERE accountCreationDate = '"+today+"' or accountCreationDate='"+yesterday+"'";
		Query<AccountNumbers> query = session.createQuery(hql, AccountNumbers.class);
		List<AccountNumbers> accounts = query.getResultList();

		System.out.println("*----------------------*------------------------------------------*");
		System.out.println("| Account Number       |Accounts Created today and yesterday      |");
		System.out.println("*----------------------*------------------------------------------*");

		for (AccountNumbers account : accounts) {
			System.out.printf("| %-20d | %-20s                     |\n", account.getAccountNumber(), account.getAccountCreationDate());
		}

		System.out.println("*----------------------*-----------------------------------------*");
	}

}
