package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.model.District;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.DistrictRepository;

@RestController
@RequestMapping("/api/v1/districts")
@CrossOrigin(origins = "http://localhost:4200")
public class DistrictController {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping
	public List<District> getAllDistricts(){
		return districtRepository.findAll();
	}
	
//	@GetMapping("/cities/{cityId}")
//	public List<District> getDistrictsByCity(@PathVariable City city) {
//		return districtRepository.findByMervancity(city);
//	}
	
	@GetMapping("/cities/{cityId}")
	public List<District> getDistrictsByCity(@PathVariable Long cityId) {
	    City city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));
	    return districtRepository.findByMervancity(city);
	}
	
	
	
	  
	

}
