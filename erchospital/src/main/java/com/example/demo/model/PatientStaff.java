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
@Table(name="MERVANSTAFF")
public class PatientStaff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_patientid")
	@SequenceGenerator(name="sequence_generator_patientid", sequenceName = "PATIENT_SEQ", allocationSize = 1)
	private Long staffId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
//	@ManyToOne
//	@JoinColumn(name="patientId")
//	private Patient patientId;
	
	@ManyToOne
	@JoinColumn(name="organizationid")
	private PatientOrganization organizationstaff;  
	
	
	
	public PatientStaff() {
		
	}
	
	

	public PatientStaff(String name, String surname,PatientOrganization organizationstaff) {
		this.name = name;
		this.surname = surname;
		this.organizationstaff=organizationstaff;
	}



	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}



	public PatientOrganization getOrganizationstaff() {
		return organizationstaff;
	}



	public void setOrganizationstaff(PatientOrganization organizationstaff) {
		this.organizationstaff = organizationstaff;
	}


	

	
	
	
	
	

}
