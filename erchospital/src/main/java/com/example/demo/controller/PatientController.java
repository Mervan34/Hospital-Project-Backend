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

import com.example.demo.dto.PatientDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.PatientModelMapper;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientPhone;
import com.example.demo.repository.PatientPhoneRepository;
import com.example.demo.repository.PatientRepository;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientPhoneRepository patientphoneRepository;
	
	@GetMapping("/patients")
	public List<PatientDTO> getAllPatients(){
		List<Patient> listPatient =  patientRepository.findAll();
		List<PatientDTO> listPatientDto = listPatient.stream().map(PatientModelMapper::toDTO).collect(Collectors.toList());
//		for(Patient entity : listPatient) {
//			PatientDTO dto = new PatientDTO();
//			dto = PatientModelMapper.toDTO(entity);
//			listPatientDto.add(dto);
//		}
		for (PatientDTO dtoPatient : listPatientDto) {
			List<PatientPhone> listPhone = getPatientPhoneByPatient(PatientModelMapper.toEntity(dtoPatient));
			if(!listPhone.isEmpty()) {
				dtoPatient.setEntityPatientPhone(listPhone.get(0));
			}
		}
		return listPatientDto;
	}
	
	@GetMapping("/patientsphone")
	public List<PatientPhone> getAllPatientPhone(){
		return patientphoneRepository.findAll();
	}
	  
	//create patients methods
	@PostMapping("/createPatient")
	public Patient createPatient(@RequestBody PatientDTO dtoPatient) {
		Patient entityPatient = PatientModelMapper.toEntity(dtoPatient);
		entityPatient = patientRepository.save(entityPatient);
		
		PatientPhone entityPhone = dtoPatient.getEntityPatientPhone();
		entityPhone.setPatient(entityPatient);
		patientphoneRepository.save(entityPhone);
		return entityPatient;
	}
	
	//get patient by id
	@GetMapping("/byid/{patientId}")
	public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long patientId) {	
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Hasta yok:"+patientId));
		
		PatientDTO patientDTO = PatientModelMapper.toDTO(patient);
		return ResponseEntity.ok(patientDTO);
	}
	
	//update patient method
	@PutMapping("/update/{patientId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId,@RequestBody PatientDTO patientDetails){
		
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Hasta yok:"+patientId));
		
		patient.setTcNo(patientDetails.getTcNo());
		patient.setBirthDate(patientDetails.getBirthDate());
		patient.setBirthPlace(patientDetails.getBirthPlace());
		patient.setGender(patientDetails.getGender());
		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		patient.setAge(patientDetails.getAge());
		patient.setAddress(patientDetails.getAddress());
		patient.setCity(patientDetails.getCity());
		patient.setDistrict(patientDetails.getDistrict());
		
		
		
		Patient updatePatient = patientRepository.save(patient);
//		PatientDTO updatedPatientDTO = PatientModelMapper.toDTO(updatePatient);
		
		PatientPhone entityPhone= patientDetails.getEntityPatientPhone();
		entityPhone.setPatient(updatePatient);
		patientphoneRepository.save(entityPhone);
		
		return ResponseEntity.ok(updatePatient);
	}
		
	   
	//delete patient method
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
		Patient patient = patientRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Hasta yok:"+id));
		
		//patientphoneRepository.deleteById(patient.getId());
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	private List<PatientPhone> getPatientPhoneByPatient(Patient patient){		
		return patientphoneRepository.findByPatient(patient);
	}
	
//	@GetMapping("/admission-patient/getPatientByTc/{tcNo}")
//	public ResponseEntity<PatientDTO> getPatientByTc(@PathVariable String tcNo) {
//	    Patient patient = patientRepository.findByTcNo(tcNo).stream().findFirst().orElse(null);
//	    if (patient != null) {
//	    	PatientDTO dtpatient=PatientModelMapper.toDTO(patient);
//	        return ResponseEntity.ok(dtpatient);
//	    }
//	    return null; 
//	}
	

	
//	@GetMapping("/getPatientByTc/{tcNo}")
//	public ResponseEntity<PatientDTO> getPatientDtoById(@PathVariable Long patientId){
//		Patient patient = patientRepository.findById(patientId)
//				.orElseThrow(()-> new ResourceNotFoundException("hasta yok"));
//		
//		PatientDTO dtopatient = PatientModelMapper.toDTO(patient);
//		return ResponseEntity.ok(dtopatient);
//	}

	
		  
	@GetMapping("/getPatientByTc/{tcNo}")
		public ResponseEntity<PatientDTO> getPatientByTc(@PathVariable String tcNo) {
			List<Patient> listPatient = patientRepository.findByTcNo(tcNo);
			PatientDTO dtoPatient = PatientDTO.getInstance();
			for (Patient patient : listPatient) {
				dtoPatient = PatientModelMapper.toDTO(patient);
			}
			return ResponseEntity.ok(dtoPatient);
		}
	
//	  @GetMapping("/by-tc/{tcNo}")
//	    public ResponseEntity<PatientDTO> getPatientByTc(@PathVariable String tcNo) {
//	        Optional<Patient> patientOpt = patientRepository.findByTcNo(tcNo);
//
//	        if (patientOpt.isPresent()) {
//	            Patient patient = patientOpt.get();
//	            PatientDTO dto = convertToDTO(patient);
//	            return ResponseEntity.ok(dto);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }


	  
}
