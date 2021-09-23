package com.hospital.booking.appointment.controllers;

import com.hospital.booking.appointment.dto.AppointmentFormsDto;
import com.hospital.booking.appointment.entities.Booking;
import com.hospital.booking.appointment.entities.Patient;
import com.hospital.booking.appointment.repositories.AppointmentRepo;
import com.hospital.booking.appointment.repositories.PatientRepo;
import com.hospital.booking.appointment.services.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/patient")
@Slf4j
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<Patient> findAllPatients(){
        return patientRepo.findAll();
    }

    @PostMapping("/book")
    public Patient addPatient(@Validated @RequestBody Patient patient){
        return patientRepo.save(patient);
    }

    @PostMapping("/appointment")
    public String bookAppointment(@Validated @RequestBody AppointmentFormsDto appointment)
    {
        log.info(appointment.toString());
        return service.bookAppointment(appointment);
    }
}
