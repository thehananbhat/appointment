package com.hospital.booking.appointment.dto;

import lombok.Data;

@Data
public class AppointmentFormsDto {
    private Integer patientId;
    private String name;
    private Integer age;
    private String contact;
}
