package com.hospital_management_system.payload;

import lombok.Data;
@Data
public class AppointmentDTO {
    private String appointmentDate;
    private String reasonForVisit;
    private Long patientId; }
