package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.PatientDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="MERVANAPPOINTMENT")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_patientid")
	@SequenceGenerator(name="sequence_generator_patientid", sequenceName = "APPOINTMENT_SEQ", allocationSize = 1)
	@Column(name="AppointmentId")
	private Long appointmentId;
	
	@Column(name="starttime")
	private String starttime;
	
	@Column(name="endtime")
	private String endtime;

	@ManyToOne
	@JoinColumn(name="organizationId")
	private PatientOrganization organizationId;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	
	public Appointment() {
		
		
	}
	
	public Appointment(String starttime, String endtime, PatientOrganization organizationId, Patient patient) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.organizationId = organizationId;
		this.patient = patient;
	}


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

	
	public PatientOrganization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(PatientOrganization organizationId) {
		this.organizationId = organizationId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
