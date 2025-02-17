package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="MERVAN_PATIENT_PHONE")
public class PatientPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_phoneid")
	@SequenceGenerator(name="sequence_generator_phoneid", sequenceName = "PATIENTPHONE_SEQ", allocationSize = 1)
	private Long id;
	
	
	@Column(name="mobilephone")
	private String mobilephone;
	
	@Column(name="homephone")
	private String homephone;
	
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patient;
	
	public PatientPhone() {
	}
	

	public PatientPhone(String mobilephone, String homephone, Patient patient) {
		this.mobilephone = mobilephone;
		this.homephone = homephone;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
