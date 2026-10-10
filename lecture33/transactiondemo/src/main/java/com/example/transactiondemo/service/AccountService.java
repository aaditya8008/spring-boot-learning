package com.example.transactiondemo.service;


import org.springframework.stereotype.Service;

import com.example.transactiondemo.entity.Account;
import com.example.transactiondemo.repository.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }
}
