package com.shapestone.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import com.shapestone.hibernate.model.Student;
import com.shapestone.hibernate.util.HibernateUtil;

public class DataRetrive {

	public void fetchAndDisplay() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		
		HibernateCriteriaBuilder criteriaBuilder = openSession.getCriteriaBuilder();
		JpaCriteriaQuery<Student> createQuery = criteriaBuilder.createQuery(Student.class);
		JpaRoot<Student> root = createQuery.from(Student.class);
		createQuery.select(root).where(criteriaBuilder.gt(root.<Integer>get("age"), 21));
		
		
		Query<Student> query = openSession.createQuery(createQuery);
		List<Student> list = query.getResultList();
		/*
		 * Query<Student> createQuery =
		 * openSession.createQuery("From Student as s order by s.age desc",
		 * Student.class);
		 * 
		 * // NativeQuery<Student> createNativeQuery =
		 * openSession.createNativeQuery("select * from student where firstName = 'abc'"
		 * , Student.class); List<Student> list = createQuery.getResultList();
		 */
		for (Student student : list) {
			System.out.println(student);
		}
		
		
	}

	public void fetchAndDisplay(int studentNumber) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Query<Student> createQuery = openSession.createQuery("From Student where id=:studentId and firstName= :name", Student.class);
		createQuery.setParameter("studentId", studentNumber);
		createQuery.setParameter("name", "sdfa");
		
//		NativeQuery<Student> createNativeQuery = openSession.createNativeQuery("select * from student where firstName = 'abc'", Student.class);
		List<Student> list = createQuery.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}

}
