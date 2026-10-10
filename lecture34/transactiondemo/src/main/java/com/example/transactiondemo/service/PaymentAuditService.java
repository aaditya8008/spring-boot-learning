package com.example.transactiondemo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactiondemo.entity.Order;
import com.example.transactiondemo.entity.PaymentAudit;
import com.example.transactiondemo.repository.PaymentAuditRepository;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ
    )
    public void audit(Order order) {
        PaymentAudit paymentAudit =
                new PaymentAudit(order.getAmount(), order.getId(), true);

        paymentAuditRepository.save(paymentAudit);
    }
}
