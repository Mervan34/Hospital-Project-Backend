package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.model.Patient;
import com.example.demo.model.PatientOrganization;

public class AppointmentDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long appointmentId;
	private String starttime;
	private String endtime;
	private PatientOrganizationDTO organizationId;
	private PatientDTO patient;
	
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	public PatientOrganizationDTO getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(PatientOrganizationDTO organizationId) {
		this.organizationId = organizationId;
	}
	public PatientDTO getPatient() {
		return patient;
	}
	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}
}
