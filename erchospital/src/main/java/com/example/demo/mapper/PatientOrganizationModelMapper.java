package com.example.demo.mapper;


import com.example.demo.dto.PatientOrganizationDTO;
import com.example.demo.model.PatientOrganization;


public class PatientOrganizationModelMapper {
	
	public static PatientOrganizationDTO toDTO(PatientOrganization entitypatientorganization) {
		PatientOrganizationDTO dtopatientorganization = new PatientOrganizationDTO();
		
		dtopatientorganization.setOrganizationId(entitypatientorganization.getOrganizationId());
		dtopatientorganization.setName(entitypatientorganization.getName());
		
		
		
		return dtopatientorganization;
	}
	
	public static PatientOrganization toEntity(PatientOrganizationDTO dtopatientorganization) {
		PatientOrganization entitypatientorganization = new PatientOrganization();
		
		entitypatientorganization.setOrganizationId(dtopatientorganization.getOrganizationId());
		entitypatientorganization.setName(dtopatientorganization.getName());
		

		return entitypatientorganization;
		
		
	} 
	
}


