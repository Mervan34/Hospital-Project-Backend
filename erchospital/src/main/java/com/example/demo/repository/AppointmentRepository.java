package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Appointment;
import com.example.demo.model.PatientOrganization;
import com.example.demo.model.PatientStaff;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	//List<Appointment> findByOrganizationIdAndStarttime(PatientOrganization organizationId, LocalDate starttime);
	
	List<Appointment> findByOrganizationId(PatientOrganization organizationId);
	
	@Query("SELECT COUNT(ap.appointmentId) FROM Appointment ap WHERE ap.patient.patientId = :patientId")
	Integer controlAdmission(@Param("patientId") Long patientId);

	@Query("SELECT ap FROM Appointment ap WHERE ap.appointmentId = :appointmentId")
	Appointment findByAppointmentId(@Param("appointmentId") Long appointmentId);
}
