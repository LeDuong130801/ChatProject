package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.RoleEntityDto;
import com.intern.chatproject.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;
    @PostMapping(value = "/create")
    public Object createRole(@RequestBody RoleEntityDto dto){
        return roleService.create(dto);
    }
    @GetMapping(value = "/get")
    public Object get(@RequestParam("role_id")String roleId){
        return roleService.getById(roleId);
    }
}
