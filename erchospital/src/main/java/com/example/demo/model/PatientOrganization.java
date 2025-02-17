package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name="MervanOrganization")
public class PatientOrganization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_patientorganizationid")
	@SequenceGenerator(name="sequence_generator_patientorganizationid", sequenceName = "PATIENTORGANIZATION_SEQ", allocationSize = 1)
	private Long organizationId;
	
	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy = "organizationstaff",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<PatientStaff> staffs;
	

	public PatientOrganization() {
		
	}

	public PatientOrganization(String name,List<PatientStaff> staffs) {
		this.name = name;
		this.staffs = staffs;
	}

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


	public List<PatientStaff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<PatientStaff> staffs) {
		this.staffs = staffs;
	}

	
	
	


	
	

}
