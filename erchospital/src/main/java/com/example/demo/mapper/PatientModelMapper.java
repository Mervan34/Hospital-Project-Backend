package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientPhone;

public class PatientModelMapper {

	public static PatientDTO toDTO(Patient entity) {
		PatientDTO dto = new PatientDTO();
		dto.setPatientId(entity.getPatientId());
		dto.setTcNo(entity.getTcNo());
		dto.setBirthDate(entity.getBirthDate());
		dto.setBirthPlace(entity.getBirthPlace());
		dto.setGender(entity.getGender());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setAddress(entity.getAddress());
		dto.setAge(entity.getAge());
		dto.setCity(entity.getCity());
		dto.setDistrict(entity.getDistrict());
		for(PatientPhone phone : entity.getListPhone()) {
			dto.setEntityPatientPhone(phone);
		}
//		dto.setListPhone(entity.getListPhone());
		return dto;
	}
	
	public static Patient toEntity(PatientDTO dto) {
		Patient entity = new Patient();
		entity.setPatientId(dto.getPatientId());
		entity.setTcNo(dto.getTcNo());
		entity.setBirthDate(dto.getBirthDate());
		entity.setBirthPlace(dto.getBirthPlace());
		entity.setGender(dto.getGender());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setAddress(dto.getAddress());
		entity.setAge(dto.getAge());
		entity.setCity(dto.getCity());
		entity.setDistrict(dto.getDistrict());
//		entity.getListPhone().add(dto.getEntityPatientPhone());
		return entity;
	}
}
