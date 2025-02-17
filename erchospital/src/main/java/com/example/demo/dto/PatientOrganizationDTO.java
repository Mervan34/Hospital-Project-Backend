package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.example.demo.model.PatientStaff;

public class PatientOrganizationDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long organizationId;
	private String name;
	private PatientStaff staffs;

	
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PatientStaff getStaffs() {
		return staffs;
	}
	public void setStaffs(PatientStaff staffs) {
		this.staffs = staffs;
	}
	
	
	
	

	
	

}
