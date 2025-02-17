package com.example.demo.mapper;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;

public class AppointmentModelMapper {
	
	public static AppointmentDTO toDTO(Appointment entity) {
		AppointmentDTO dtoappointment = new AppointmentDTO();
		
		dtoappointment.setAppointmentId(entity.getAppointmentId());
		dtoappointment.setStarttime(entity.getStarttime());
		dtoappointment.setEndtime(entity.getEndtime());
		dtoappointment.setOrganizationId(PatientOrganizationModelMapper.toDTO(entity.getOrganizationId()));
//		dtoappointment.setOrganizationId(entity.getOrganizationId());
		if(entity.getPatient() != null) {
			dtoappointment.setPatient(PatientModelMapper.toDTO(entity.getPatient()));
		}
//		dtoappointment.setPatient(PatientModelMapper.toDTO(entity.getPatient()));
		
		return dtoappointment;
		
	}
	
	public static Appointment toEntity(AppointmentDTO dto) {
		Appointment appointment = new Appointment();
		
		appointment.setAppointmentId(dto.getAppointmentId());
		appointment.setStarttime(dto.getStarttime());
		appointment.setEndtime(dto.getEndtime());
		appointment.setOrganizationId(PatientOrganizationModelMapper.toEntity(dto.getOrganizationId()));
//		appointment.setOrganizationId(dto.getOrganizationId());
		if(dto.getPatient() != null) {
			appointment.setPatient(PatientModelMapper.toEntity(dto.getPatient()));
		}
//		appointment.setPatient(PatientModelMapper.toEntity(dto.getPatient()));
		
		return appointment;
	}


}
