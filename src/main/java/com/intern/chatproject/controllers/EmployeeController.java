package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.EmployeeEntityDto;
import com.intern.chatproject.entities.TokenEntity;
import com.intern.chatproject.services.impl.EmployeeServiceImpl;
import com.intern.chatproject.services.impl.TokenServiceImpl;
import com.intern.chatproject.utils.Constrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    TokenServiceImpl tokenService;

    @GetMapping(value = "/get")
    public Object get(@RequestParam(value = "employee_id") String employeeId){
        return employeeService.getDtoById(employeeId);
    }
    @PostMapping(value = "/create")
    public Object createEmployee(@RequestBody EmployeeEntityDto dto){
        return employeeService.create(dto);
    }

    @PutMapping(value = "/edit")
    public Object editEmployee(@RequestBody EmployeeEntityDto dto){
        return employeeService.edit(dto);
    }
    @DeleteMapping(value = "/delete")
    public Object delete(@RequestBody List<String> employeeIdList){
        return employeeService.delete(employeeIdList);
    }
    @PostMapping(value = "/login-process")
    public Object login(@RequestBody EmployeeEntityDto dto) {
        return employeeService.login(dto, tokenService);
    }

    @GetMapping(value = "/filter")
    public Object filter(@RequestParam(value = "employee_id", required = false)String employeeId,
                         @RequestParam(value = "employee_name", required = false)String employeeName,
                         @RequestParam(value = "role_id", required = false) String roleId){
        return employeeService.filterEmployee(employeeId, employeeName, roleId);
    }
}
