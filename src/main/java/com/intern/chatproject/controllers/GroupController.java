package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.GroupEntityDto;
import com.intern.chatproject.services.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    GroupServiceImpl groupService;

    @PostMapping(value = "/create")
    Object create(@RequestBody GroupEntityDto dto){
        return groupService.create(dto);
    }
}
