package com.example.transactiondemo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactiondemo.entity.Order;
import com.example.transactiondemo.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private PaymentAuditService paymentAuditService;

    public OrderService(OrderRepository orderRepository,
                        PaymentAuditService paymentAuditService) {
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

    @Transactional
    public void placeOrder(Order order) {
        orderRepository.save(order);

        paymentAuditService.audit(order);
    }
}
