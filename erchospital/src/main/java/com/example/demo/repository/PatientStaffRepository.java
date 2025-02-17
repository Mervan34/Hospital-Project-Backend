package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;
import com.example.demo.model.District;
import com.example.demo.model.PatientOrganization;
import com.example.demo.model.PatientStaff;

@Repository
public interface PatientStaffRepository extends JpaRepository<PatientStaff, Long>{
	
//	List<PatientStaff> findByPatientOrganization(PatientOrganization patientorganization);

	List<PatientStaff> findByOrganizationstaff(PatientOrganization organizationstaff);
	
}
