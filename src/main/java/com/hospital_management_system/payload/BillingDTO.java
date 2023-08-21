package com.hospital_management_system.payload;

import lombok.Data;

@Data
public class BillingDTO {
    private Long id;
    private Long patientId;
    private String insuranceProvider;
    private String policyNumber;
    private double totalAmount; }


