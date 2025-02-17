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
@RequestMapping("/api/v1/cities/")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@GetMapping("/all")
	public List<City> getAllCities(){
		return cityRepository.findAll();
	}
	
//	@GetMapping("/{cityId}/districts")
//	public List<District> getDistrictByCity(@PathVariable City cityId){
//		return districtRepository.findByMervancity(cityId);
//	}
	
	@GetMapping("/{cityId}/districts")
	public List<District> getDistrictByCity(@PathVariable Long cityId) {
	    City city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));
	    return districtRepository.findByMervancity(city);
	}
	
//	@GetMapping("/{cityId}/districts")
//	public List<District> getDistrictByCity(@PathVariable Long cityId) {
//	    System.out.println("Received cityId: " + cityId); // Log cityId
//	    City city = cityRepository.findById(cityId)
//	        .orElseThrow(() -> new RuntimeException("City not found"));
//	    System.out.println("City found: " + city); // Log City object
//	    List<District> districts = districtRepository.findByMervancity(city);
//	    System.out.println("Districts found: " + districts); // Log Districts
//	    return districts;
//	}

}
