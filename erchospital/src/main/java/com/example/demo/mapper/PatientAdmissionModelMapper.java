package com.example.demo.mapper;

import com.example.demo.dto.PatientAdmissionDTO;
import com.example.demo.model.PatientAdmission;

public class PatientAdmissionModelMapper {
	
	public static PatientAdmissionDTO toDTO(PatientAdmission entity) {
		PatientAdmissionDTO dtopatientadmission = new PatientAdmissionDTO();
		
		dtopatientadmission.setAdmissionId(entity.getAdmissionId());
		dtopatientadmission.setAdmissionDate(entity.getAdmissionDate());
		dtopatientadmission.setAdmissionType(entity.getAdmissionType());
		dtopatientadmission.setNote(entity.getNote());
		dtopatientadmission.setStatus(entity.getStatus());
		dtopatientadmission.setPatientId(entity.getPatientId());
		dtopatientadmission.setOrganizationId(PatientOrganizationModelMapper.toDTO(entity.getOrganizationId()));
		dtopatientadmission.setStaffId(entity.getStaffId());
		
		return dtopatientadmission;
		
	}
	
	public static PatientAdmission toEntity(PatientAdmissionDTO dtopatientadmission) {
		PatientAdmission entitypatientadmission = new PatientAdmission();
		
		entitypatientadmission.setAdmissionId(dtopatientadmission.getAdmissionId());
		entitypatientadmission.setAdmissionDate(dtopatientadmission.getAdmissionDate());
		entitypatientadmission.setAdmissionType(dtopatientadmission.getAdmissionType());
		entitypatientadmission.setNote(dtopatientadmission.getNote());
		entitypatientadmission.setPatientId(dtopatientadmission.getPatientId());
		entitypatientadmission.setOrganizationId(PatientOrganizationModelMapper.toEntity(dtopatientadmission.getOrganizationId()));
		entitypatientadmission.setStaffId(dtopatientadmission.getStaffId());
		entitypatientadmission.setStatus(dtopatientadmission.getStatus());
		
		
		return entitypatientadmission;
	}

	

}



