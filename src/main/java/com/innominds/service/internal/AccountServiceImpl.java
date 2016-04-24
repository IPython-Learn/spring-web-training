package com.innominds.service.internal;

import com.innominds.service.AccountService;

public class AccountServiceImpl implements AccountService {

    @Override
    public int getCode() {
        return hashCode();
    }
}
