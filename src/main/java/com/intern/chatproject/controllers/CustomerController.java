package com.intern.chatproject.controllers;


import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl userAccountService;

    @PostMapping("/login-process")
    public Object loginProcess(@RequestBody CustomerEntityDto dto){
        return userAccountService.login(dto);
    }

    @PostMapping("/sign-up-process")
    public Object signUpProcess(@RequestBody CustomerEntityDto dto){
        return userAccountService.create(dto);
    }

    @PutMapping("/change-password-process")
    public Object changePasswordProcess(@RequestBody CustomerEntityDto dto){
        return userAccountService.changePassword(dto);
    }

    @PutMapping("/edit")
    public Object edit(@RequestBody CustomerEntityDto dto){
        return userAccountService.edit(dto);
    }
    @PutMapping("/forgot-password")
    public Object forgotPassword(@RequestBody CustomerEntityDto dto){
        return userAccountService.forgotPassword(dto);
    }
//    @GetMapping("/loginSuccess")
//    public String loginSuccess(@AuthenticationPrincipal OAuth2User principal) {
//        return "redirect:/";
//    }
//    @PostMapping("/get")
//    public Object get(@RequestBody CustomerEntityDto dto){
//        return userAccountService.
//    }
}
