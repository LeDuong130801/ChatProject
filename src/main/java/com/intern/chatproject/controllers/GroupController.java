package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.GroupEntityDto;
import com.intern.chatproject.services.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    GroupServiceImpl groupService;

    @PostMapping(value = "/create")
    Object create(@RequestBody GroupEntityDto dto){
        return groupService.create(dto);
    }
    @GetMapping(value = "/get")
    Object get(@RequestParam(value = "group_id") String groupId){
        return groupService.getById(groupId);
    }
}
