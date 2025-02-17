package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.PatientOrganization;

public class PatientStaffDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long staffId;
	private String name;
	private String surname;
	private PatientOrganization organizationstaff;
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
