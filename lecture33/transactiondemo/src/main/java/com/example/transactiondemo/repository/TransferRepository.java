package com.example.transactiondemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactiondemo.entity.TransferRecord;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}
