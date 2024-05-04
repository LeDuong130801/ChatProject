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
    Object create(
                  @RequestParam("user_account_id") String userAccountId){
        return chatBoxService.create(userAccountId);
    }
    @PostMapping("/customer/get")
    Object getChatBoxOfCustomer(@RequestBody ChatBoxEntityDto dto){
        return chatBoxService.getChatBoxOfCustomer(dto.getCustomerId());
    }
    @GetMapping("/customer/get")
    Object getChatBoxDtoDetailOfEmployee(
            @RequestParam(value = "website_origin", required = false)String websiteOrigin,
            @RequestParam(value = "website_name", required = false)String websiteName,
            @RequestParam(value = "customer_id")String customerId){
        return chatBoxService.getChatBoxDetailOfCustomer(websiteOrigin, websiteName, customerId);
    }
    @GetMapping("/employee/get")
    Object getChatBoxDtoDetailOfCustomer(
            @RequestParam(value = "website_origin", required = false)String websiteOrigin,
            @RequestParam(value = "website_name", required = false)String websiteName,
            @RequestParam(value = "employee_id")String employeeId
            ){
        return chatBoxService.getAllChatBoxDetailOfEmployee(websiteOrigin, websiteName, employeeId);
    }
    @PostMapping("/employee/get")
    Object getChatBoxOfEmployee(@RequestBody ChatBoxEntityDto dto){
        return chatBoxService.getChatBoxOfEmployee(dto.getEmployeeId());
    }

}
