package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PatientAdmissionDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.PatientAdmissionModelMapper;
import com.example.demo.mapper.PatientOrganizationModelMapper;
import com.example.demo.model.PatientAdmission;
import com.example.demo.repository.PatientAdmissionRepository;
import com.example.demo.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientAdmissionController {
	
	@Autowired
	private PatientAdmissionRepository patientadmissionRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	//dto list
	@GetMapping("/patientsadmission")
	public List<PatientAdmissionDTO> getAllAdmissions(){
		List<PatientAdmission> listadmission = patientadmissionRepository.findAll();
		List<PatientAdmissionDTO> listadmissionDto = listadmission.stream().map(PatientAdmissionModelMapper::toDTO).collect(Collectors.toList());
		
		return listadmissionDto;
	}
	

	@GetMapping("/allpatientadmission")
	public List<PatientAdmission> getAllPatientsAdmission(){
		return patientadmissionRepository.findAll();
	}
	
	@GetMapping("/check/{patientId}")
	public boolean checkAdmission(@PathVariable Long patientId) {
		Integer listAdmission = patientadmissionRepository.controlAdmission(patientId);
		if(listAdmission > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@PostMapping("/createAdmission")
	public PatientAdmission createAdmission(@RequestBody PatientAdmissionDTO dtopatientadmission) {
		
		PatientAdmission entityadmissionpatient = PatientAdmissionModelMapper.toEntity(dtopatientadmission);
		entityadmissionpatient = patientadmissionRepository.save(entityadmissionpatient);
		
		
		return entityadmissionpatient;
	}
	
	//get patientadmission by id 
	@GetMapping("/admissionbyid/{admissionId}")
	public PatientAdmissionDTO getAdmissionById(@PathVariable Long admissionId){
		PatientAdmission patientadmission = patientadmissionRepository.findById(admissionId)
				.orElseThrow(()-> new ResourceNotFoundException("hasta yok"));
		
		PatientAdmissionDTO dtopatientadmission = PatientAdmissionModelMapper.toDTO(patientadmission);
		return dtopatientadmission;
	}
	
	@PutMapping("/updateadmission/{admissionId}")
	public ResponseEntity<PatientAdmission> updateAdmission(@PathVariable Long admissionId,@RequestBody PatientAdmissionDTO admissionDetails){
		
		PatientAdmission patientadmission = patientadmissionRepository.findById(admissionId)
				.orElseThrow(()-> new ResourceNotFoundException("hasta yok"));
		
		patientadmission.setAdmissionId(admissionDetails.getAdmissionId());
		patientadmission.setAdmissionDate(admissionDetails.getAdmissionDate());
		patientadmission.setAdmissionType(admissionDetails.getAdmissionType());
		patientadmission.setNote(admissionDetails.getNote());
		patientadmission.setPatientId(admissionDetails.getPatientId());
		patientadmission.setOrganizationId(PatientOrganizationModelMapper.toEntity(admissionDetails.getOrganizationId()));
		patientadmission.setStaffId(admissionDetails.getStaffId());
		patientadmission.setStatus(admissionDetails.getStatus());
		
		
		PatientAdmission updatePatientAdmission=patientadmissionRepository.save(patientadmission);
		
		return ResponseEntity.ok(updatePatientAdmission);
	}
	

		
	@DeleteMapping("/deleteadmission/{admissionId}")
	public ResponseEntity<Map<String, Boolean>> deleteAdmission(@PathVariable Long admissionId){
		PatientAdmission patientadmission = patientadmissionRepository.findById(admissionId)
				.orElseThrow(()-> new ResourceNotFoundException("hasta yok"));
		
		patientadmissionRepository.delete(patientadmission);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
//	 @GetMapping("/getPatientByTc/{tcNo}")
//		public PatientDTO getPatientByTc(String tcNo) {
//			List<Patient> listPatient = patientRepository.findByTcNo(tcNo);
//			PatientDTO dtoPatient = new PatientDTO();
//			for (Patient patient : listPatient) {
//				dtoPatient = PatientModelMapper.toDTO(patient);
//			}
//			return dtoPatient;
//		}
	
	


}
