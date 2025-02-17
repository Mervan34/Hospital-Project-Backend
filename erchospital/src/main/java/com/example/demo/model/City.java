package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "MERVANCITY")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_cityid")
	@SequenceGenerator(name="sequence_generator_cityid", sequenceName = "CITY_SEQ", allocationSize = 1)
	@Column(name="mervancityid")
	private Long mervancityid;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy ="mervancity",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<District> districts;
	
	public City() {
		
	}

	public Long getMervancityid() {
		return mervancityid;
	}

	public void setMervancityid(Long mervancityid) {
		this.mervancityid = mervancityid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

}
