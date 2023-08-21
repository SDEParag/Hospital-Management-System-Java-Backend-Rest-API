package com.hospital_management_system.service;

import com.hospital_management_system.entity.Billing;

public interface BillingService {
    Billing getBillingById(Long id);
    boolean deleteBillingById(Long id);


}
