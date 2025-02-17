package com.example.demo.model;

import java.time.LocalDate;

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
@Table(name = "MervanPatientAdmission")
public class PatientAdmission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_patientid")
	@SequenceGenerator(name="sequence_generator_patientid", sequenceName = "PATIENTADMISSION_SEQ", allocationSize = 1)
	private Long admissionId;
	
	@Column(name="admissiondate")
	private LocalDate admissionDate;
	
	@Column(name="admissiontype")
	private String admissionType;
	
	@Column(name="note")
	private String note;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patientId;
	
	
	@ManyToOne
	@JoinColumn(name="organizationid")
	private PatientOrganization organizationId;
	
	@ManyToOne
	@JoinColumn(name="staffid")
	private PatientStaff staffId;
	


	public PatientAdmission() {
		
	}

	public PatientAdmission(Long admissionId, LocalDate admissionDate, String admissionType, String note, String status,
			 Patient patientId,PatientOrganization organizationId, PatientStaff staffId) {
		this.admissionId = admissionId;
		this.admissionDate = admissionDate;
		this.admissionType = admissionType;
		this.note = note;
		this.status = status;
		this.patientId = patientId;
		this.organizationId = organizationId;
		this.staffId = staffId;
	}

	public Long getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	

	public PatientOrganization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(PatientOrganization organizationId) {
		this.organizationId = organizationId;
	}

	public PatientStaff getStaffId() {
		return staffId;
	}

	public void setStaffId(PatientStaff staffId) {
		this.staffId = staffId;
	}

	

	

	
	
	
	
	
	

}
