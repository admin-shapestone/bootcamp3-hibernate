package com.shapestone.hibernate.bankingdomain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.model.Student;
import com.shapestone.hibernate.util.HibernateUtil;

public class DataRetrive {
public void fetchDataAndDisplayAccounts() {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session openSession = sessionFactory.openSession();
	NativeQuery<AccountNumbers> createNativeQuery = openSession.createNativeQuery("select * from account", AccountNumbers.class);
	List<AccountNumbers> list = createNativeQuery.getResultList();
	for (AccountNumbers accountData : list) {
		System.out.println(accountData);
}
}
}
