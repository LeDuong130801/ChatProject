package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.WebsiteEntityDto;
import com.intern.chatproject.services.impl.WebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/web")
public class WebsiteController {

    @Autowired
    WebsiteServiceImpl websiteService;

    @PostMapping(value = "/create")
    Object create(@RequestBody WebsiteEntityDto dto){
        return websiteService.create(dto);
    }

    @PostMapping(value = "/get-by-website-name")
    Object getByWebsiteName(@RequestBody WebsiteEntityDto dto){
        return websiteService.getByWebsiteName(dto.getWebsiteName());
    }
    @GetMapping(value = "/get")
    Object get(@RequestParam(value = "website_id")String websiteId){
        return websiteService.getById(websiteId);
    }
}
