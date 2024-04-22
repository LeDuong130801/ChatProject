package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.WebsiteEntityDto;
import com.intern.chatproject.services.impl.WebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class WebsiteController {

    @Autowired
    WebsiteServiceImpl websiteService;

    @PostMapping(value = "/create")
    Object create(@RequestBody WebsiteEntityDto dto){
        return websiteService.create(dto);
    }
}
