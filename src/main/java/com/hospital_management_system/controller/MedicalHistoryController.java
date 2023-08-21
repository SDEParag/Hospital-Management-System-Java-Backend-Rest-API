package com.hospital_management_system.controller;


import com.hospital_management_system.entity.MedicalHistory;
import com.hospital_management_system.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/medical-history")
public class MedicalHistoryController {


    private final MedicalHistoryService medicalHistoryService;


    @Autowired
    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistory> getMedicalHistoryById(@PathVariable("id") Long id) {
        MedicalHistory medicalHistory = medicalHistoryService.getMedicalHistoryById(id);
        if (medicalHistory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medicalHistory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistoryById(@PathVariable("id") Long id) {
        boolean deleted = medicalHistoryService.deleteMedicalHistoryById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
