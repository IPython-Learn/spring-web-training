package com.innominds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innominds.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankService bankService;

    @RequestMapping("/account")
    public ResponseEntity<Integer> getAccountNumber() {

        System.err.println(bankService.getAccountNumber());

        return new ResponseEntity<Integer>(bankService.getAccountNumber(), HttpStatus.OK);
    }

}
