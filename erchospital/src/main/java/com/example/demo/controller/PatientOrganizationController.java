package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientOrganizationController {
	
	@Autowired
	private PatientOrganizationRepository patientorganizationRepository;
	
	@Autowired
	private PatientStaffRepository patientstaffRepository;

	
	@GetMapping("/allorganization")
	private List<PatientOrganization> getAllPatientOrganization(){
		return patientorganizationRepository.findAll();
	}

	
	
	@GetMapping("/{organizationId}/patientstaff")
	public List<PatientStaff> getStaffByOrganization(@PathVariable Long organizationId){
		PatientOrganization patientorganization = patientorganizationRepository.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization found"));
	    return patientstaffRepository.findByOrganizationstaff(patientorganization);
	}
	
//	@GetMapping("/staff/{staffId}")
//	public List<PatientOrganization> getAppointmentByStaff(@PathVariable Long staffId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
//		PatientStaff staff = patientstaffRepository.findById(staffId)
//				.orElseThrow(() -> new EntityNotFoundException("doktor bulunamadı"));
//				
//				return patientorganizationRepository.findByStaffsAndAppointmentDate(staff, date);
//	}
//	

	
//	@PostMapping
//	public PatientOrganization createAppointmnet(@RequestBody PatientOrganization patientorganization) {
//		return patientorganizationRepository.save(patientorganization);
//	}
	


	
	

	
}
