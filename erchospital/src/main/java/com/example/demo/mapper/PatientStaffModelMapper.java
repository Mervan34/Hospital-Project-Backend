package com.example.demo.mapper;


import com.example.demo.dto.PatientStaffDTO;
import com.example.demo.model.PatientStaff;

public class PatientStaffModelMapper {
	
	public static PatientStaffDTO toDTO(PatientStaff entitypatientstaff) {
		
		PatientStaffDTO dtopatientstaff = new PatientStaffDTO();
		
		dtopatientstaff.setName(entitypatientstaff.getName());
		dtopatientstaff.setOrganizationstaff(entitypatientstaff.getOrganizationstaff());
		dtopatientstaff.setSurname(entitypatientstaff.getSurname());
		dtopatientstaff.setStaffId(entitypatientstaff.getStaffId());
		
		return dtopatientstaff;
	}
	
	
	public static PatientStaff toEntity(PatientStaffDTO dtopatientstaff) {
		
		PatientStaff entitypatientstaff = new PatientStaff();
		
		entitypatientstaff.setName(dtopatientstaff.getName());
		entitypatientstaff.setOrganizationstaff(dtopatientstaff.getOrganizationstaff());
		entitypatientstaff.setStaffId(dtopatientstaff.getStaffId());
		entitypatientstaff.setSurname(dtopatientstaff.getSurname());

		
		
		return entitypatientstaff;
		
		
		
	}
	


}


