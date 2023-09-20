package com.shapestone.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "certificates")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Certificates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificateId;
	private String institutionName;
	private String courseName;
	private String dateOfCertificationDone;
	private long cost;
	@Transient
	private int studentId;
	
	
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDateOfCertificationDone() {
		return dateOfCertificationDone;
	}
	public void setDateOfCertificationDone(String dateOfCertificationDone) {
		this.dateOfCertificationDone = dateOfCertificationDone;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Certificates [certificateId=" + certificateId + ", institutionName=" + institutionName + ", courseName="
				+ courseName + ", dateOfCertificationDone=" + dateOfCertificationDone + ", cost=" + cost
				+ ", studentId=" + studentId + "]";
	}
	
	
	
	

}
