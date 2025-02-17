package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.demo.model.Patient;
import com.example.demo.model.PatientOrganization;
import com.example.demo.model.PatientStaff;

public class PatientAdmissionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long admissionId;
	private LocalDate admissionDate;
	private String admissionType;
	private String note;
	private String status;
	private Patient patientId;
	private PatientOrganizationDTO organizationId;
	private PatientStaff staffId;
	
	
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
	
	public PatientOrganizationDTO getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(PatientOrganizationDTO organizationId) {
		this.organizationId = organizationId;
	}
	public PatientStaff getStaffId() {
		return staffId;
	}
	public void setStaffId(PatientStaff staffId) {
		this.staffId = staffId;
	}
	
	
	
	

}
