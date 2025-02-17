package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PatientOrganization;
import com.example.demo.model.PatientStaff;

@Repository
public interface PatientOrganizationRepository extends JpaRepository<PatientOrganization, Long>{

//    List<PatientOrganization> findByStaffsAndAppointmentDate(PatientStaff staffs, LocalDate appointmentDate);


}
