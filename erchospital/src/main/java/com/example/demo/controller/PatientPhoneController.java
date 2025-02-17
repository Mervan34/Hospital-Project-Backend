package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.PatientPhone;
import com.example.demo.repository.PatientPhoneRepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientPhoneController {
	
	@Autowired
	private PatientPhoneRepository patientphoneRepository;
	
	@GetMapping("/allphone")
	public List<PatientPhone> getAllCities(){
		return patientphoneRepository.findAll();
	}
	
	@PostMapping("/createPatientPhone")
	public PatientPhone createPatientPhone(@RequestBody PatientPhone patientphone) {
		
		return patientphoneRepository.save(patientphone);
	}
	
//	public List<PatientPhone> getPatientPhoneByPatient(Long patientId){
//		return patientphoneRepository.findByPatientPhone(patientId);
//	}

}
