package com.hospital.booking.appointment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.booking.appointment.dto.AppointmentFormsDto;
import com.hospital.booking.appointment.entities.Booking;
import com.hospital.booking.appointment.entities.Patient;
import com.hospital.booking.appointment.repositories.AppointmentRepo;
import com.hospital.booking.appointment.repositories.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
@Slf4j
public class AppointmentService {

    @Autowired
    private AppointmentRepo apprepo;

    @Autowired
    private PatientRepo patientrepo;

    public String bookAppointment(AppointmentFormsDto appointmentFormsDto) {

//        ModelMapper modelMapper = new ModelMapper();
//        Patient patient = modelMapper.map(app, Patient.class);

        Patient patient= new ObjectMapper().convertValue(appointmentFormsDto,Patient.class);


//        patient.setPatientId(50L);

        log.info(patient.toString());

//        Patient patient = new Patient();
//        patient.setName("dog");
//        patient.setAge(5);
//        patient.setContact("79903833");

        patientrepo.save(patient);

        int patientNumber = patient.getPatientId();

        log.info(String.valueOf(patientNumber));

        System.out.println("Patient inputted correctly");

        Booking appointment=new Booking(new Date(System.currentTimeMillis()), 101L, patientNumber);

        Integer appointmentNumber = apprepo.save(appointment).getBookingId();

        return "Appointment number assigned: "+appointmentNumber;

    }

}
