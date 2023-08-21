package com.hospital_management_system.controller;


import com.hospital_management_system.entity.Patient;
import com.hospital_management_system.payload.PatientDTO;
import com.hospital_management_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/patients")
public class PatientController {


    private final PatientService patientService;


    @Autowired
    public PatientController(PatientService patientService) {


        this.patientService = patientService;
    }


    @PreAuthorize("hasRole('ADMIN')") // Only admin can create
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }


}

