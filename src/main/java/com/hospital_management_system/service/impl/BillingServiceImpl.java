package com.hospital_management_system.service.impl;

import com.hospital_management_system.entity.Billing;
import com.hospital_management_system.repository.BillingRepository;
import com.hospital_management_system.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillingServiceImpl implements BillingService {


    private final BillingRepository billingRepository;


    @Autowired
    public BillingServiceImpl(BillingRepository billingRepository) {


        this.billingRepository = billingRepository;
    }


    @Override
    public Billing getBillingById(Long id) {


        return billingRepository.findById(id).orElse(null);
    }


    @Override
    public boolean deleteBillingById(Long id) {
        if (billingRepository.existsById(id)) {
            billingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
