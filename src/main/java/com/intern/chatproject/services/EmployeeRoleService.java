package com.intern.chatproject.services;

import com.intern.chatproject.dto.EmployeeRoleEntityDto;

import java.util.List;

public interface EmployeeRoleService {
    Object create(EmployeeRoleEntityDto dto);
    Object edit(EmployeeRoleEntityDto dto);
    List<String> delete(List<String> employeeRoleIdList);
    Object removeRoleOfEmployee(String roleId, String employeeId);
}
