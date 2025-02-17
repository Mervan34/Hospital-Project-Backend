package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.PatientAdmissionDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.AppointmentModelMapper;
import com.example.demo.mapper.PatientAdmissionModelMapper;
import com.example.demo.mapper.PatientModelMapper;
import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientAdmission;
import com.example.demo.model.PatientOrganization;
import com.example.demo.model.PatientPhone;
import com.example.demo.model.PatientStaff;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.PatientOrganizationRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PatientOrganizationRepository patientorganizationRepository;

	
	@GetMapping("/allappointment")
	public List<Appointment> getAllAppointment(@PathVariable Long appointmentId){
		return appointmentRepository.findAll();
	}
	
	@GetMapping("/allappointmentorganization")
	private List<PatientOrganization> getAllPatientOrganization(){
		return patientorganizationRepository.findAll();
	}
		
	@GetMapping("/appointment/{organizationId}")
	public List<Appointment> getAppointmentByOrganization(@PathVariable Long organizationId){
		PatientOrganization appointmentorganization = patientorganizationRepository.findById(organizationId)
				.orElseThrow(() -> new EntityNotFoundException("doktor bulunamadı"));
				
				return appointmentRepository.findByOrganizationId(appointmentorganization);
				
	}
	
	@GetMapping("/appointmentlist")
	public List<AppointmentDTO> AppointmentList(){
		List<Appointment> listAppointment = this.appointmentRepository.findAll();
		List<AppointmentDTO> listAppointmentDto = listAppointment.stream().map(AppointmentModelMapper::toDTO).collect(Collectors.toList());
		
		return listAppointmentDto;
	}
	
//	public List<PatientAdmissionDTO> getAllAdmissions(){
//		List<PatientAdmission> listadmission = patientadmissionRepository.findAll();
//		List<PatientAdmissionDTO> listadmissionDto = listadmission.stream().map(PatientAdmissionModelMapper::toDTO).collect(Collectors.toList());
//		
//		return listadmissionDto;
//	}
	
//	@GetMapping("/byid/{patientId}")
//	public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long patientId) {	
//		Patient patient = patientRepository.findById(patientId)
//				.orElseThrow(()-> new ResourceNotFoundException("Hasta yok:"+patientId));
//		
//		PatientDTO patientDTO = PatientModelMapper.toDTO(patient);
//		return ResponseEntity.ok(patientDTO);
//	}
	
		
	@PostMapping("/createAppointment")
	public Appointment createAppointmnet(@RequestBody AppointmentDTO dtoAppointment) {
		Appointment entityAppointment = appointmentRepository.findByAppointmentId(dtoAppointment.getAppointmentId());
		entityAppointment.setPatient(PatientModelMapper.toEntity(dtoAppointment.getPatient()));
//		entityAppointment.setPatientId(PatientModelMapper.toEntity(dtoAppointment.getPatientId()));
		
		entityAppointment = appointmentRepository.save(entityAppointment);
		
		return entityAppointment;
	}
	

}
