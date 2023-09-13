package com.shapestone.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.shapestone.hibernate.model.Student;
import com.shapestone.hibernate.util.HibernateUtil;

public class DataRetrive {

	public void fetchAndDisplay() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		NativeQuery<Student> createNativeQuery = openSession.createNativeQuery("select * from student", Student.class);
		List<Student> list = createNativeQuery.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
		
		
	}

}
