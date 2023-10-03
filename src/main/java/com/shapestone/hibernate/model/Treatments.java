package com.shapestone.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "treatments")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Treatments {
	@Column
	private int slNo;
    @Id
	private String treatmentId;
	@Column
	private String disease;
	@Column
	private String treatment;
	@Column
	private double costOfTreatment;
	@Column
	private String dateOfTreatment;
	@Column
	private String diagnosis;
	@Column
	private double costOfDiagnosis;
	@Column
	private double costOfMedicines;
	@Column
	private double totalCost;
	@Column
	private String patientId;
	
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	public String getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public double getCostOfTreatment() {
		return costOfTreatment;
	}
	public void setCostOfTreatment(double costOfTreatment) {
		this.costOfTreatment = costOfTreatment;
	}
	public String getDateOfTreatment() {
		return dateOfTreatment;
	}
	public void setDateOfTreatment(String dateOfTreatment) {
		this.dateOfTreatment = dateOfTreatment;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public double getCostOfDiagnosis() {
		return costOfDiagnosis;
	}
	public void setCostOfDiagnosis(double costOfDiagnosis) {
		this.costOfDiagnosis = costOfDiagnosis;
	}
	public double getCostOfMedicines() {
		return costOfMedicines;
	}
	public void setCostOfMedicines(double costOfMedicines) {
		this.costOfMedicines = costOfMedicines;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "Treatments [slNo=" + slNo + ", treatmentId=" + treatmentId + ", disease=" + disease + ", treatment="
				+ treatment + ", costOfTreatment=" + costOfTreatment + ", dateOfTreatment=" + dateOfTreatment
				+ ", diagnosis=" + diagnosis + ", costOfDiagnosis=" + costOfDiagnosis + ", costOfMedicines="
				+ costOfMedicines + ", totalCost=" + totalCost + ", patientId=" + patientId + "]";
	}
	
	
	
	

}
