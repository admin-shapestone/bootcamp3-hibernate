package com.shapestone.hibernate;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Patients;
import com.shapestone.hibernate.util.HibernateUtil;

public class TodayAndYesterdayJoined {
	public static void joinedTodayAndYesterday() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session os = sf.openSession();

		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);

		String hql = "FROM Patients WHERE dateOfJoining='" + today + "' OR dateOfJoining='" + yesterday + "' ";

		Query<Patients> createQuery = os.createQuery(hql, Patients.class);

		List<Patients> list = createQuery.getResultList();

		// Print table headers
		System.out.printf("%-5s %-10s %-20s %-10s %-15s %-15s %-10s%n", "slNo", "patientId", "patientName",
				"patientAge", "weight", "dateOfJoining", "cost");

		// Print patient information in a table format
		for (Patients patient : list) {
			System.out.printf("%-5s %-10s %-20s %-10s %-15s %-15s %-10s%n", patient.getSlNo(), patient.getPatientId(),
					patient.getPatientName(), patient.getPatientAge(), patient.getWeight(), patient.getDateOfJoining(),
					patient.getCost());
		}
	}

}
