package com.intern.chatproject.controllers;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.intern.chatproject.entities.IdTokenEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Controller
public class HomeController {

    static NetHttpTransport transport = new NetHttpTransport();

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
    @GetMapping(value = "/logingoogle")
    ResponseEntity<?> loggg(
            @RequestParam(value = "credential", required = false) String credential,
            @RequestParam(value = "g_csrf_token", required = false) String token,
    @RequestBody(required = false) String body){
        log.info(body);
        log.info(credential);
        log.info(token);
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, new GsonFactory())
                    .setAudience(Collections.singletonList("890054659261-fl3pla3surhpuoud6bd8e2s6h9g85ib2.apps.googleusercontent.com"))
                    .build();

            GoogleIdToken idToken = verifier.verify(token);
            if (idToken != null) {
                Payload payload = idToken.getPayload();
                String email = payload.getEmail();
                log.info(email);
            } else {
                System.out.println("Invalid ID token.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(":)");
    }
    @GetMapping("/example")
    public String example() {
        // Khởi tạo RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Thực hiện yêu cầu GET
        String url = "localhost:8080/logingooge";
        String responseBody = restTemplate.getForObject(url, String.class);

        // In ra responseBody
        System.out.println("ResponseBody: " + responseBody);

        // Trả về responseBody cho client
        return responseBody;
    }
}