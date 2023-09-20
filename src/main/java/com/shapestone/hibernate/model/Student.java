package com.shapestone.hibernate.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	private int id;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name = "age")
	private int age;

	public int getId() {
		return id;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Certificates> certList;
	
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age
				+ ", certList=" + certList + "]";
	}

	public List<Certificates> getCertList() {
		return certList;
	}

	public void setCertList(List<Certificates> certList) {
		this.certList = certList;
	}
	
	
	

}
