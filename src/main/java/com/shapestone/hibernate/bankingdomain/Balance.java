package com.shapestone.hibernate.bankingdomain;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Payments;
import com.shapestone.hibernate.util.HibernateUtil;

public class Balance {

	public void totalBalance() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the account holder Name:");
	    String accountHolder = scanner.nextLine();
	    String sql = "SELECT\r\n"
	    		+ "    SUM(a.balance) + IFNULL(SUM(p.credits), 0) - IFNULL(SUM(p.debits), 0) AS updated_balance \r\n"
	    		+ "FROM\r\n"
	    		+ "    account a \r\n"
	    		+ "INNER JOIN\r\n"
	    		+ "    payments p \r\n"
	    		+ "        ON a.accountNumber = p.accountNumber\r\n"
	    		+ "WHERE CONCAT(a.first_Name, ' ', a.last_Name) = ?";
        NativeQuery<Double> query = session.createNativeQuery(sql);
        query.setParameter(1, accountHolder); 

        Double updatedBalance = (Double) query.uniqueResult();

        if (updatedBalance != null) {
            System.out.println("*----------------------*----------------------*");
            System.out.println("| Account Holder       | Updated Balance      |");
            System.out.println("*----------------------*----------------------*");
            System.out.printf("| %-20s | %-20s |\n", accountHolder, updatedBalance);
            System.out.println("*----------------------*----------------------*");
        } else {
            System.out.println("Account not found.");
        }

        session.close();
	}

	}
	


