package com.hospital_management_system.payload;

import lombok.Data;
import java.util.Date;
import java.util.List;


@Data
public class PatientDTO {
    private Long id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private MedicalHistoryDTO medicalHistory;
    private List<AppointmentDTO> appointments;
    private BillingDTO billing; }


