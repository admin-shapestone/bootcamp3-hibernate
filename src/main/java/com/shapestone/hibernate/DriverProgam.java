package com.shapestone.hibernate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shapestone.hibernate.model.Certificates;
import com.shapestone.hibernate.model.Student;
import com.shapestone.hibernate.util.HibernateUtil;

public class DriverProgam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean wannaContinue = true;
		dumpData();
		Scanner scanner = new Scanner(System.in);
		while (wannaContinue) {			
			System.out.println("Select any option from below menu..");
			System.out.println("1). Fetch and Display data");
			System.out.println("2). Insert Data");
			System.out.println("3). Update Data");
			System.out.println("4). Delete Data");
			System.out.println("5). Sort by name");
			System.out.println("6). total cost");

			int option = scanner.nextInt();

			if (option == 1) {
				DataRetrive retrive = new DataRetrive();
				System.out.println("Enter student number to load details");
				int studentNumber = scanner.nextInt();
				if (studentNumber > 0) {
					retrive.fetchAndDisplay(studentNumber);
				}
				retrive.fetchAndDisplay();
			} else if (option == 2) {
				InsertData insertData = new InsertData();
				insertData.insertData(scanner);
			}
			else if (option == 4) {
				System.out.println("Enter student Id to delete");
				int sId = scanner.nextInt();
				DumpData dumpData = new DumpData();
				dumpData.deleteStudentById(sId);
			}
			else {
				System.out.println("You have choosen worng option....");
			}
			System.out.println("Do you want to continue...");
			String continueCheck = scanner.next();
			if (!continueCheck.equalsIgnoreCase("yes")) {
				wannaContinue = false;
			}
		}

	}

	private static void dumpData() {
		ObjectMapper mapper = new ObjectMapper();
		Student[] studentData = null;
		Certificates[] certificateData = null;
		try {
			studentData = mapper.readValue(new File("students.json"), Student[].class);
			certificateData = mapper.readValue(new File("certificates.json"), Certificates[].class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		
		for (Student student : studentData) {
			List<Certificates> addCertstoStudent = addCertstoStudent(student, certificateData);
			student.setCertList(addCertstoStudent);
			openSession.persist(student);
		}
		beginTransaction.commit();
		
	}

	private static List<Certificates> addCertstoStudent(Student student, Certificates[] certificateData) {
		List<Certificates> certs = new ArrayList<>();
		for (Certificates cert : certificateData) {
			if (student.getId() == cert.getStudentId()) {
				certs.add(cert);
			}
		}
		return certs;
	}

}
