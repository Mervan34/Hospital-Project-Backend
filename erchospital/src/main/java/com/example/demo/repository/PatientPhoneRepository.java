package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;
import com.example.demo.model.PatientPhone;

@Repository
public interface PatientPhoneRepository extends JpaRepository<PatientPhone, Long>{

	List<PatientPhone> findByPatient(Patient patient);
}
