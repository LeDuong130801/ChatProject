package com.intern.chatproject.services;

import com.intern.chatproject.dto.EmployeeEntityDto;

import java.util.List;

public interface EmployeeService {
    Object create(EmployeeEntityDto dto);
    Object edit(EmployeeEntityDto dto);
    List<String> delete(List<String> employeeIdList);
    Object getDtoById(String employeeId);
}
