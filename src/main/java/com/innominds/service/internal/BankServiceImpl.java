package com.innominds.service.internal;

import org.springframework.beans.factory.annotation.Autowired;

import com.innominds.service.AccountService;
import com.innominds.service.BankService;

public class BankServiceImpl implements BankService {

    @Autowired
    AccountService accountService;

    @Override
    public int getAccountNumber() {
        System.err.println(accountService);
        return accountService.getCode();
    }
}
