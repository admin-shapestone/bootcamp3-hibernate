package com.shapestone.hibernate.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patients {
	@Column
	private int slNo;
	@Id
	private String patientId;
	@Column
	private String patientName;
	@Column
	private int patientAge;
	@Column
	private String weight;
	@Column
	private  String dateOfJoining;
	@Column
	private  String dateOfDischarge;
	@Column
	private double cost;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	private List<Treatments> treatmentsList;

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(String dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Treatments> getTreatmentsList() {
		return treatmentsList;
	}

	public void setTreatmentsList(List<Treatments> treatmentsList) {
		this.treatmentsList = treatmentsList;
	}

	@Override
	public String toString() {
		return "Patients [slNo=" + slNo + ", patientId=" + patientId + ", patientName=" + patientName + ", patientAge="
				+ patientAge + ", weight=" + weight + ", dateOfJoining=" + dateOfJoining + ", dateOfDischarge="
				+ dateOfDischarge + ", cost=" + cost + ", treatmentsList=" + treatmentsList + "]";
	}
	
	

}
