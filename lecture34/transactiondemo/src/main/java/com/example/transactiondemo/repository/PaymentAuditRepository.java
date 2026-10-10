package com.example.transactiondemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactiondemo.entity.PaymentAudit;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit, Long> {
}
