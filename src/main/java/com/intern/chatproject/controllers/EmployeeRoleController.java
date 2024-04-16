package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.EmployeeRoleEntityDto;
import com.intern.chatproject.services.impl.EmployeeRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/employee-role")
public class EmployeeRoleController {
    @Autowired
    EmployeeRoleServiceImpl employeeRoleService;

    @GetMapping("/get")
    public Object getEmployeeRole(@RequestParam("employee_role_id") String employeeRoleId){
        return employeeRoleService.getById(employeeRoleId);
    }
    @PostMapping(value = "/create")
    public Object createEmployeeRole(@RequestBody EmployeeRoleEntityDto dto){
        return employeeRoleService.create(dto);
    }
}
