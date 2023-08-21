package com.hospital_management_system.service.impl;

import com.hospital_management_system.entity.MedicalHistory;
import com.hospital_management_system.repository.MedicalHistoryRepository;
import com.hospital_management_system.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {


    private final MedicalHistoryRepository medicalHistoryRepository;


    @Autowired
    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }


    @Override
    public MedicalHistory getMedicalHistoryById(Long id) {


        return medicalHistoryRepository.findById(id).orElse(null);
    }


    @Override
    public boolean deleteMedicalHistoryById(Long id) {
        if (medicalHistoryRepository.existsById(id)) {
            medicalHistoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


