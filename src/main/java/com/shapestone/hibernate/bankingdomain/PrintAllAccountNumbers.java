package com.shapestone.hibernate.bankingdomain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

public class PrintAllAccountNumbers {

	public void dispalyAccountNUmbers() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
	    HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    JpaCriteriaQuery<AccountNumbers> criteriaQuery = criteriaBuilder.createQuery(AccountNumbers.class);
	    JpaRoot<AccountNumbers> root = criteriaQuery.from(AccountNumbers.class);
	    criteriaQuery.select(root);

	    List<AccountNumbers> accounts = session.createQuery(criteriaQuery).getResultList();

	    System.out.println("*----------------------*");
	    System.out.println("| Account Numbers       |");
	    System.out.println("*----------------------*");

	    for (AccountNumbers account : accounts) {
	        System.out.printf("| %-20d |\n", account.getAccountNumber());
	    }
	    System.out.println("*----------------------*");
	    session.close();
	}	

}
