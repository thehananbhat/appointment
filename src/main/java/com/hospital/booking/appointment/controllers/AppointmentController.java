package com.hospital.booking.appointment.controllers;

import com.hospital.booking.appointment.entities.Booking;
import com.hospital.booking.appointment.repositories.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class AppointmentController {

    @Autowired
    AppointmentRepo appointmentRepo;


    @GetMapping
    public List<Booking> findAllBookings(){
        return appointmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findAppointmentById(@PathVariable(value = "id") Long appointmentId) {
        Optional<Booking> appointment = appointmentRepo.findById(appointmentId);
        if(appointment.isPresent()) {
            return ResponseEntity.ok().body(appointment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
