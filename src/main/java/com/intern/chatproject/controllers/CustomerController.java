package com.intern.chatproject.controllers;


import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.GoogleUserInfo;
import com.intern.chatproject.services.impl.CustomerServiceImpl;
import com.intern.chatproject.services.impl.TokenServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    TokenServiceImpl tokenService;

    @PostMapping("/login-process")
    public Object loginProcess(@RequestBody CustomerEntityDto dto){
        return customerService.login(dto, tokenService);
    }

    @PostMapping("/sign-up-process")
    public Object signUpProcess(@RequestBody CustomerEntityDto dto){
        return customerService.create(dto, tokenService);
    }

    @PutMapping("/change-password-process")
    public Object changePasswordProcess(@RequestBody CustomerEntityDto dto){
        return customerService.changePassword(dto);
    }

    @PutMapping("/edit")
    public Object edit(@RequestBody CustomerEntityDto dto){
        return customerService.edit(dto);
    }
    @PutMapping("/forgot-password")
    public Object forgotPassword(@RequestBody CustomerEntityDto dto){
        return customerService.forgotPassword(dto);
    }
    @PostMapping(value = "/logingoogle")
    public Object loginGoogle(@RequestBody GoogleUserInfo userInfo){
        return customerService.login(userInfo, tokenService);
    }

}
