package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.EmployeeEntityDto;
import com.intern.chatproject.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

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
}
