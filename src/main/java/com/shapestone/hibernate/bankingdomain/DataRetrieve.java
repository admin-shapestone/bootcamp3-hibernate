package com.shapestone.hibernate.bankingdomain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import com.shapestone.hibernate.model.AccountNumbers;
import com.shapestone.hibernate.util.HibernateUtil;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DataRetrieve {
	public void fetchDataAndDisplayAccounts() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<AccountNumbers> createQuery = criteriaBuilder.createQuery(AccountNumbers.class);
        JpaRoot<AccountNumbers> root = (JpaRoot<AccountNumbers>) createQuery.from(AccountNumbers.class);
       createQuery.select(root);
        Query<AccountNumbers>query=((Session) openSession()).createQuery(createQuery);
       // for (AccountNumbers accountData : accountList) {
            //System.out.println(accountData);
        //}
        session.close();
       

       
    }






		
		
	

	private Object openSession() {
		// TODO Auto-generated method stub
		return null;
	}










	public void fetchDataAndDisplayPayments() {
		
	}

}
