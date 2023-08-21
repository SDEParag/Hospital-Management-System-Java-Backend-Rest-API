package com.hospital_management_system.repository;

import com.hospital_management_system.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}


