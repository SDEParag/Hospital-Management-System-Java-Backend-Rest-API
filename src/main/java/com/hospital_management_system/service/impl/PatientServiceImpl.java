package com.hospital_management_system.service.impl;

import com.hospital_management_system.entity.Appointment;
import com.hospital_management_system.entity.Billing;
import com.hospital_management_system.entity.MedicalHistory;
import com.hospital_management_system.entity.Patient;
import com.hospital_management_system.payload.PatientDTO;
import com.hospital_management_system.repository.AppointmentRepository;
import com.hospital_management_system.repository.BillingRepository;
import com.hospital_management_system.repository.MedicalHistoryRepository;
import com.hospital_management_system.repository.PatientRepository;
import com.hospital_management_system.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;
    private final MedicalHistoryRepository medicalHistoryRepository;
    private final AppointmentRepository appointmentRepository;
    private final BillingRepository billingRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository,
                              MedicalHistoryRepository medicalHistoryRepository,
                              AppointmentRepository appointmentRepository,
                              BillingRepository billingRepository,
                              ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.appointmentRepository = appointmentRepository;
        this.billingRepository = billingRepository;
        this.modelMapper = modelMapper;
    }


    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patient = patientRepository.save(patient);


        // Map MedicalHistory
        MedicalHistory medicalHistory = modelMapper.map(patientDTO.getMedicalHistory(), MedicalHistory.class);
        medicalHistory.setPatient(patient);
        medicalHistoryRepository.save(medicalHistory);


        // Map Appointments
        Patient finalPatient = patient;
        patientDTO.getAppointments().forEach(appointmentDTO -> {
            Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
            appointment.setPatient(finalPatient);
            appointmentRepository.save(appointment);
        });


        // Map Billing
        Billing billing = modelMapper.map(patientDTO.getBilling(), Billing.class);
        billing.setPatient(patient);
        billingRepository.save(billing);


        return patient;
    }


    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
