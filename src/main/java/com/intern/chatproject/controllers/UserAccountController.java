package com.intern.chatproject.controllers;


import com.intern.chatproject.services.impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-account")
public class UserAccountController {
    @Autowired
    UserAccountServiceImpl userAccountService;


}
