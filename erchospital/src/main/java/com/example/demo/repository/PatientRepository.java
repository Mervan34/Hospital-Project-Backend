package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	
    //boolean check(String tcNo, String firstName, String lastName, int age, String gender);
	
//	@Query("SELECT p FROM Patient p WHERE p.tcNo = :tcNo")
	List<Patient> findByTcNo(String tcNo);
	
	
	

}
