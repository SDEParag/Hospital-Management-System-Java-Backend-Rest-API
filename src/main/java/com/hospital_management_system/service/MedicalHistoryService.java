package com.hospital_management_system.service;


import com.hospital_management_system.entity.MedicalHistory;

public interface MedicalHistoryService {
    MedicalHistory getMedicalHistoryById(Long id);
    boolean deleteMedicalHistoryById(Long id);
}
