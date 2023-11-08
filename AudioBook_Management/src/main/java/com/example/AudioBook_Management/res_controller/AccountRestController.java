package com.example.AudioBook_Management.res_controller;

import com.example.AudioBook_Management.service.AccountService;
import com.example.AudioBook_Management.service.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountRestController {
    AccountService accountService;
    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "password") String password,
                                    @RequestParam(name = "re_password") String re_password) {
        return ResponseEntity.ok(accountService.createAccountLisener(email,password,re_password));
    }
}
