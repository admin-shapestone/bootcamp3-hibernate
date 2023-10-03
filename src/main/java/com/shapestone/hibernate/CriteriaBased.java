package com.shapestone.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaInsertSelect;

import com.shapestone.hibernate.model.Patients;
import com.shapestone.hibernate.util.HibernateUtil;

public class CriteriaBased {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session open = sf.openSession();

		HibernateCriteriaBuilder cb = open.getCriteriaBuilder();
		JpaCriteriaInsertSelect<Patients> cr = cb.createCriteriaInsertSelect(Patients.class);

		
		
		
	}

}
