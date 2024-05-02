package com.intern.chatproject.controllers;


import com.intern.chatproject.dto.ChatBoxEntityDto;
import com.intern.chatproject.services.impl.ChatBoxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/chatbox")
public class ChatBoxController {
    @Autowired
    ChatBoxServiceImpl chatBoxService;

    @PostMapping("/create")
    Object create(@RequestParam("user_account_id") String userAccountId){
        return chatBoxService.create(userAccountId);
    }
    @PostMapping("/customer/get")
        //truyen them websiteid???
    Object getChatBoxOfCustomer(@RequestBody ChatBoxEntityDto dto){
        return chatBoxService.getChatBoxOfCustomer(dto.getCustomerId());
    }
    @GetMapping("/customer/get")
    Object getChatBoxDtoDetailOfCustomer(
            @RequestParam(value = "website_id", required = false)String websiteId,
            @RequestParam(value = "website_name", required = false)String websiteName,
            @RequestParam(value = "employee_id")String employeeId
            ){
        return chatBoxService.getAllChatBoxDetail(websiteId, websiteName, employeeId);
    }
    @PostMapping("/employee/get")
    Object getChatBoxOfEmployee(@RequestBody ChatBoxEntityDto dto){
        return chatBoxService.getChatBoxOfEmployee(dto.getEmployeeId());
    }

}
