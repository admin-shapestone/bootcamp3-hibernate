package com.shapestone.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Patients;
import com.shapestone.hibernate.util.HibernateUtil;

public class SortByName {
	public static void sortByName() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session os = sf.openSession();

		// Use HQL to retrieve and sort by patientName in ascending order
		String hql = "FROM Patients ORDER BY patientName ASC";
		Query<Patients> query = os.createQuery(hql, Patients.class);

		List<Patients> list = query.getResultList();

		// Print patients table header
		System.out.println("Patients Table:");
		System.out.println("+-------+-----------+-------------+------------+-----------+---------------+-----------------+");
		System.out.println("| slNo  | patientId | patientName | patientAge | weight    | dateOfJoining | dateOfDischarge |");
		System.out.println("+-------+-----------+-------------+------------+-----------+---------------+-----------------+");

		for (Patients patient : list) {
			// Print each patient in a formatted row
			System.out.printf("| %-5d | %-9s | %-11s | %-9d | %-9s | %-11s | %-15s |\n", patient.getSlNo(),
					patient.getPatientId(), patient.getPatientName(), patient.getPatientAge(), patient.getWeight(),
					patient.getDateOfJoining(), patient.getDateOfDischarge());
		}

		// Print table footer
		System.out.println("+-------+---------+---------------+------------+-----------+---------------+-----------------+");

	}

}
