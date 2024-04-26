package com.intern.chatproject.controllers;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.GoogleUserInfo;
import com.intern.chatproject.services.impl.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    static NetHttpTransport transport = new NetHttpTransport();

    @PostMapping("/login-process")
    public Object loginProcess(@RequestBody CustomerEntityDto dto){
        return customerService.login(dto);
    }

    @PostMapping("/sign-up-process")
    public Object signUpProcess(@RequestBody CustomerEntityDto dto){
        return customerService.create(dto);
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
    @PostMapping("/login-with-google")
    public Object loginWithGoogle(@RequestBody CustomerEntityDto dto){
        return customerService.login(dto);
    }
    @PostMapping(value = "/logingoogle")
    public Object loginGoogle(@RequestBody GoogleUserInfo userInfo){
        return customerService.login(userInfo);
    }
    @PostMapping(value = "/loginguest")
    public Object loginGuest(@RequestBody CustomerEntityDto dto){
        return customerService.loginGuest(dto);
    }
//    @GetMapping("/loginSuccess")
//    public String loginSuccess(@AuthenticationPrincipal OAuth2User principal) {
//        return "redirect:/";
//    }
//    @PostMapping("/get")
//    public Object get(@RequestBody CustomerEntityDto dto){
//        return customerService.
//    }
}
