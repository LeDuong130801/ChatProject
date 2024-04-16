package com.intern.chatproject.controllers;


import com.intern.chatproject.dto.UserAccountDto;
import com.intern.chatproject.services.impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user-account")
public class UserAccountController {
    @Autowired
    UserAccountServiceImpl userAccountService;

    @PostMapping("/login-process")
    public Object loginProcess(@RequestBody UserAccountDto dto){
        return userAccountService.login(dto);
    }

    @PostMapping("/sign-up-process")
    public Object signUpProcess(@RequestBody UserAccountDto dto){
        return userAccountService.create(dto);
    }

    @PutMapping("/change-password-process")
    public Object changePasswordProcess(@RequestBody UserAccountDto dto){
        return userAccountService.changePassword(dto);
    }

    @PutMapping("/edit")
    public Object edit(UserAccountDto dto){
        return userAccountService.edit(dto);
    }
}
