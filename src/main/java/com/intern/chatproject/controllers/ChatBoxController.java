package com.intern.chatproject.controllers;


import com.intern.chatproject.services.impl.ChatBoxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatbox")
public class ChatBoxController {
    @Autowired
    ChatBoxServiceImpl chatBoxService;

    @PostMapping("/create")
    Object create(String userAccountId){
        return chatBoxService.create(userAccountId);
    }

}
