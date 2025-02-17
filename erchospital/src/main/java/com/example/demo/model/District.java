package com.example.demo.model;

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
@Table(name="MERVANDISTRICTS")
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_districtid")
	@SequenceGenerator(name="sequence_generator_districtid", sequenceName = "DISTRICT_SEQ", allocationSize = 1)
	@Column(name="mervandistrictid")
	private Long mervandistrictid;
	
	@Column(name = "name")
	private String name;
	
//	@ManyToOne
//	@JoinColumn(name = "mervancityid",nullable=false)
//	private City city;
	
	
	@ManyToOne
	@JoinColumn(name = "mervancityid",nullable=false)
	private City mervancity;

	public District() {
		
	}

	
	public District(String name, City city) {
		super();
		this.name = name;
		this.mervancity = city;
	}




	public Long getMervandistrictid() {
		return mervandistrictid;
	}

	public void setMervandistrictid(Long mervandistrictid) {
		this.mervandistrictid = mervandistrictid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}




	public City getMervancity() {
		return mervancity;
	}




	public void setMervancity(City mervancity) {
		this.mervancity = mervancity;
	}

}
