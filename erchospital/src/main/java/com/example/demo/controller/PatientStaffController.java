package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.model.District;
import com.example.demo.model.PatientOrganization;
import com.example.demo.model.PatientStaff;
import com.example.demo.repository.PatientOrganizationRepository;
import com.example.demo.repository.PatientStaffRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientStaffController {
	
	@Autowired
	private PatientStaffRepository patientstaffRepository;
	
	@Autowired
	private PatientOrganizationRepository patientorganizationRepository;
	
	
	
	@GetMapping("/allstaff")
	public List<PatientStaff> getAllPatientStaff(){
		return patientstaffRepository.findAll();
	}
	

	
	@GetMapping("/patientorganization/{organizationId}")
	public List<PatientStaff> getStaffByOrganization(@PathVariable Long organizationId){
		PatientOrganization patientorganization = patientorganizationRepository.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization found"));
	    return patientstaffRepository.findByOrganizationstaff(patientorganization);
	}



	

	

}
