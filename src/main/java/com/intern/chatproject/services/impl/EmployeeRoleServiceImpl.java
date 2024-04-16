package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.EmployeeRoleEntityDto;
import com.intern.chatproject.entities.EmployeeRoleEntity;
import com.intern.chatproject.repositories.jpa.EmployeeRoleRepositoryJpa;
import com.intern.chatproject.services.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    EmployeeRoleRepositoryJpa employeeRoleRepositoryJpa;

    @Override
    public Object create(EmployeeRoleEntityDto dto) {
        EmployeeRoleEntity entity = EmployeeRoleEntity.builder()
                .employeeRoleId(UUID.randomUUID().toString())
                .roleId(dto.getRoleId())
                .employeeId(dto.getEmployeeId())
                .build();
        return employeeRoleRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(EmployeeRoleEntityDto dto) {
        return null;
    }

    @Override
    public List<String> delete(List<String> employeeRoleIdList) {
        return null;
    }

    @Override
    public Object removeRoleOfEmployee(String roleId, String employeeId) {
        return null;
    }

    public Object getById(String employeeRoleId){
        return employeeRoleRepositoryJpa.getEmployeeRoleEntityDtoByEmployeeRoleId(employeeRoleId);
    }
}
