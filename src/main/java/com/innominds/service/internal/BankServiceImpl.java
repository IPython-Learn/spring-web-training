package com.innominds.service.internal;

import org.springframework.beans.factory.annotation.Autowired;

import com.innominds.service.AccountService;
import com.innominds.service.BankService;

public class BankServiceImpl implements BankService {

    @Autowired
    private AccountService accountService;

    @Override
    // @PostAuthorize("hasRole('ROLE_ADMIN')")
    // @Secured("ROLE_ADMIN")
    // @PreAuthorize("isAuthenticated()")
    public int getAccountNumber() {
        System.err.println(accountService);
        return accountService.getCode();
    }
}
