package com.example.demo.mapper;

import com.example.demo.dto.PatientPhoneDTO;
import com.example.demo.model.PatientPhone;

public class PatientPhoneModelMapper {
	public static PatientPhoneDTO toDTO(PatientPhone entity) {
		PatientPhoneDTO dto = new PatientPhoneDTO();
		dto.setId(entity.getId());
		dto.setHomephone(entity.getHomephone());
		dto.setMobilephone(entity.getMobilephone());
		dto.setPatientId(entity.getPatient().getPatientId());
		return dto;
	}

	public static PatientPhone toEntity(PatientPhoneDTO dto) {
		PatientPhone entity = new PatientPhone();
		entity.setId(dto.getId());
		entity.setHomephone(dto.getHomephone());
		entity.setMobilephone(dto.getMobilephone());
		dto.setPatientId(entity.getPatient().getPatientId());
		return entity;
	}

}
