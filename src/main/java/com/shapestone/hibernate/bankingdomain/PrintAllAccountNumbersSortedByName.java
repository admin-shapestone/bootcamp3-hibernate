package com.shapestone.hibernate.bankingdomain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

public class PrintAllAccountNumbersSortedByName {

	public void accountsSorted() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
	    String hql = "FROM AccountNumbers ORDER BY firstName,lastName ASC";
	    
	    Query<AccountNumbers> query = session.createQuery(hql, AccountNumbers.class);
	    List<AccountNumbers> accounts = query.getResultList();

	    System.out.println("*----------------------*----------------------*");
	    System.out.println("| Account Number       | Account Holder       |");
	    System.out.println("*----------------------*----------------------*");

	    for (AccountNumbers account : accounts) {
	        System.out.printf("| %-20d | %-20s |\n", account.getAccountNumber(), account.getFirstName() + " " + account.getLastName());
	    }

	    System.out.println("*----------------------*----------------------*");
	    session.close();
		
	}

	
}
