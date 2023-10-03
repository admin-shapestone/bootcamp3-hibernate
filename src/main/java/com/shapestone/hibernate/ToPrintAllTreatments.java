package com.shapestone.hibernate;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Treatments;
import com.shapestone.hibernate.util.HibernateUtil;

public class ToPrintAllTreatments {
	public static void toPrintAllTreatments() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session os = sf.openSession();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the patient Name: ");
		String patName = scanner.next();

		Query<Treatments> createQuery = os.createQuery(
				"SELECT p.treatmentsList FROM Patients p WHERE p.patientName = :patName", Treatments.class);
		createQuery.setParameter("patName", patName);

		List<Treatments> list = createQuery.getResultList();

		System.out.println(
				"+-----+------------+----------------+----------------------+------------------+----------------+");
		System.out.println(
				"| SlNo|  PatientId |   Disease      |   Treatment          | DateOfTreatment  |    Diagnosis   |");
		System.out.println(
				"+-----+------------+----------------+----------------------+------------------+----------------+");

		// Print table data
		for (Treatments treatments : list) {
			System.out.format("| %-4s| %-11s| %-10s| %-10s| %-20s| %-20s|%n", treatments.getSlNo(),
					treatments.getPatientId(),

					treatments.getDisease(), treatments.getTreatment(), treatments.getDateOfTreatment(),
					treatments.getDiagnosis());
		}

		// Print table footer
		System.out.println(
				"+-----+------------+---------------+-----------------------+-------------------+--------------+");
	}
}
