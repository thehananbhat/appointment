package com.hospital.booking.appointment.repositories;

import com.hospital.booking.appointment.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Booking, Long> {
}
