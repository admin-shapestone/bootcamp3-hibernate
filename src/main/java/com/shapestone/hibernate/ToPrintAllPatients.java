package com.shapestone.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Patients;
import com.shapestone.hibernate.util.HibernateUtil;

public class ToPrintAllPatients {
	public static void toPrintAllPatients() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();

		// Create an HQL query to select all patients
		String hql = "FROM Patients";
		Query<Patients> query = openSession.createQuery(hql, Patients.class);

		List<Patients> list = query.getResultList();

		// Print patients table header
		System.out.println("Patients Table:");
		System.out.println(
				"+-------+-----------+-------------+------------+-----------+---------------+-----------------+");
		System.out.println(
				"| slNo  | patientId | patientName | patientAge | weight    | dateOfJoining | dateOfDischarge |");
		System.out.println(
				"+-------+-----------+-------------+------------+-----------+---------------+-----------------+");

		for (Patients patient : list) {
			// Print each patient in a formatted row
			System.out.printf("| %-5d | %-9s | %-11s | %-9d | %-9s | %-11s | %-15s |\n", patient.getSlNo(),
					patient.getPatientId(), patient.getPatientName(), patient.getPatientAge(), patient.getWeight(),
					patient.getDateOfJoining(), patient.getDateOfDischarge());
		}

		// Print table footer
		System.out.println(
				"+-------+---------+---------+---------+-----------+-----------+-----------------------------+");

	}

}
