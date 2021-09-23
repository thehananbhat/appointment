package com.hospital.booking.appointment.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;

    private String name;
    private Integer age;
    private String contact;


}
