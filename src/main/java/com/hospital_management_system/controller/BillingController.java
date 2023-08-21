package com.hospital_management_system.controller;


import com.hospital_management_system.entity.Billing;
import com.hospital_management_system.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/billing")
public class BillingController {


    private final BillingService billingService;


    @Autowired
    public BillingController(BillingService billingService) {


        this.billingService = billingService;
    }




    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable("id") Long id) {
        Billing billing = billingService.getBillingById(id);
        if (billing == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(billing);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBillingById(@PathVariable("id") Long id) {
        boolean deleted = billingService.deleteBillingById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();  } }
