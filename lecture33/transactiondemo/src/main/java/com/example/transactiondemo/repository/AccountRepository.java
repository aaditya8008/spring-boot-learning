package com.example.transactiondemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transactiondemo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
