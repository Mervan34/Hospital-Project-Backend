package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.City;
import com.example.demo.model.District;
import com.example.demo.model.PatientPhone;

public class PatientDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long patientId;
	private String tcNo;
	private LocalDate birthDate;
	private String birthPlace;
	private String gender;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private City city;  
	private District district; 
//	private List<PatientPhone> listPhone = new ArrayList<PatientPhone>();
	private PatientPhone entityPatientPhone;
	
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
	//	public List<PatientPhone> getListPhone() {
//		return listPhone;
//	}
//	public void setListPhone(List<PatientPhone> listPhone) {
//		this.listPhone = listPhone;
//	}
	public PatientPhone getEntityPatientPhone() {
		return entityPatientPhone;
	}
	public void setEntityPatientPhone(PatientPhone entityPatientPhone) {
		this.entityPatientPhone = entityPatientPhone;
	}
	
	//SİNGLETON
	private static PatientDTO instance;
	
	public static PatientDTO getInstance() {
		if(instance==null) {
			instance= new PatientDTO();
		}
		return instance;
	}

}
