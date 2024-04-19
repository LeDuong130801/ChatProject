package com.intern.chatproject.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
public class HomeController {
    @GetMapping({"/", "/index"})
    String index(){
        return "index.html";
    }
    @GetMapping("/login/oauth2/code/google")
    String i(){
        return "index.html";
    }
    @GetMapping("/test")
    ResponseEntity<?> testConnect(){
        return ResponseEntity.ok("OK");
    }
}
