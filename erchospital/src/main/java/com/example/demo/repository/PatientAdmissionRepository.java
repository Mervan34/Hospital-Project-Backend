package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;
import com.example.demo.model.PatientAdmission;

@Repository
public interface PatientAdmissionRepository extends JpaRepository<PatientAdmission, Long>{
	
//	List<Patient> findByTcNo(String tcNo);

//	Optional<PatientAdmission> findById(Long patientId);
	
	@Query("SELECT COUNT(adm.admissionId) FROM PatientAdmission adm WHERE adm.patientId.patientId = :patientId")
	Integer controlAdmission(@Param("patientId") Long patientId);
	

}
