package com.shapestone.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.shapestone.hibernate.model.Treatments;
import com.shapestone.hibernate.util.HibernateUtil;

public class TotalCost {

    public static void toPrintAllTreatmentsCost() {
        System.out.println("Enter patientName: ");
        Scanner scan = new Scanner(System.in);
        String patName = scan.next();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session os = sf.openSession();

        Query<Treatments> createQuery = os.createQuery(
            "SELECT p.treatmentsList FROM Patients p WHERE p.patientName = :patName", Treatments.class);
        createQuery.setParameter("patName", patName);
        List<Treatments> list = createQuery.getResultList();

        // Print table headers
        System.out.format("%-5s %-10s %-15s %-15s %-15s %-15s%n", 
            "SlNo", "PatientId", "DiagnosisCost", "MedicinesCost", "TreatmentCost", "TotalCost");

        for (Treatments cost : list) {
            System.out.format("%-5s %-10s %-15.2f %-15.2f %-15.2f %-15.2f%n", 
                cost.getSlNo(), cost.getPatientId(), cost.getCostOfDiagnosis(),
                cost.getCostOfMedicines(), cost.getCostOfTreatment(), cost.getTotalCost());
        }
        
        os.close();
    }
}
