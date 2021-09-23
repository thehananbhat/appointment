package com.hospital.booking.appointment.repositories;

import com.hospital.booking.appointment.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
