package com.hospital.booking.appointment.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    private Date date;
    private Long doctorNo;
    private int patientNo;

    public Booking(Date date, Long l, int patientNumber) {
        this.date = date;
        this.doctorNo = l;
        this.patientNo = patientNumber;
    }
}
