package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
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
@Table(name = "Mervanpatients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_patientid")
	@SequenceGenerator(name="sequence_generator_patientid", sequenceName = "PATIENT_SEQ", allocationSize = 1)
	@Column(name = "PATIENTID")
	private Long patientId;
	
	@Column(name = "TCNo")
	private String tcNo;
	

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birthdate")
	private LocalDate birthDate;
	
	@Column(name = "birthplace")
	private String birthPlace;
	
	@Column(name = "age")
	private int age;
	
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "mervancityid")
	private City city;  
	
	@ManyToOne
	@JoinColumn(name = "mervandistrictid")
	private District district; 
	
	@OneToMany(mappedBy ="patient",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<PatientPhone> listPhone = new ArrayList<PatientPhone>();
	
	public Patient() {
		
		
	}
	

	public Patient(String tcNo,String firstName, String lastName,LocalDate birthDate,String birthPlace, int age,String gender, String address,City city,District district, List<PatientPhone> listPhone) {
		
		this.tcNo = tcNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.city=city;
		this.district=district;
		this.listPhone = listPhone;
	}
	
	
	public Long getPatientId() {
		return patientId;
	}


	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	
	
	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public List<PatientPhone> getListPhone() {
		return listPhone;
	}


	public void setListPhone(List<PatientPhone> listPhone) {
		this.listPhone = listPhone;
	}

}
