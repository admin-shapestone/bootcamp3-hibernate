package com.shapestone.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shapestone.hibernate.model.Patients;
import com.shapestone.hibernate.util.HibernateUtil;

public class DeleteData {

    @SuppressWarnings("deprecation")
    public static void deleteByPatientId(String patientId) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session openSession = sf.openSession();

        Transaction transaction = openSession.beginTransaction();

        Patients patient = openSession.byNaturalId(Patients.class).using("patientId", patientId).load();
        if (patient != null) {
            openSession.delete(patient);
            transaction.commit();
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record with patientId " + patientId + " not found.");
        }

        openSession.close();
    }
}
