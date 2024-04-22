package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.EmployeeEntityDto;
import com.intern.chatproject.entities.EmployeeEntity;
import com.intern.chatproject.repositories.jpa.EmployeeRepositoryJpa;
import com.intern.chatproject.repositories.jpa.EmployeeRoleRepositoryJpa;
import com.intern.chatproject.services.EmployeeService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.Util;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepositoryJpa employeeRepositoryJpa;
    @Autowired
    EmployeeRoleRepositoryJpa employeeRoleRepositoryJpa;

    @Override
    public Object create(EmployeeEntityDto dto) {
        if (employeeRepositoryJpa.existsEmployeeEntityByUsername(dto.getUsername())) {
            throw new CustomException("username already exist");
        }
        Long currentTime = System.currentTimeMillis();
        String employeeId = UUID.randomUUID().toString();
        while (employeeRepositoryJpa.existsEmployeeEntityByEmployeeId(employeeId)) {
            employeeId = UUID.randomUUID().toString();
        }
        EmployeeEntity entity = EmployeeEntity.builder()
                .employeeId(UUID.randomUUID().toString())
                .employeeName(dto.getEmployeeName())
                .phoneNumber(dto.getPhoneNumber())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .status(Constrants.STATUS.ACTIVE)
                .updateBy(Util.auth())
                .createBy(Util.auth())
                .updateTime(currentTime)
                .createTime(currentTime)
                .build();
        return employeeRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(EmployeeEntityDto dto) {
        Optional<EmployeeEntity> entityOptional = employeeRepositoryJpa.getEmployeeEntityByEmployeeId(dto.getEmployeeId());
        if (entityOptional.isEmpty()) {
            throw new CustomException("Employee id: " + dto.getEmployeeId() + " not exist");
        }
        EmployeeEntity entity = entityOptional.get();
        if (employeeRepositoryJpa.existsEmployeeEntityByUsernameAndUsernameIsNot(dto.getUsername(), entity.getUsername())) {
            throw new CustomException("Username: " + entity.getUsername() + " already exist");
        }
        entity.setEmployeeName(dto.getEmployeeName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());

        entity.setUpdateBy(Util.auth());
        entity.setUpdateTime(System.currentTimeMillis());
        return employeeRepositoryJpa.save(entity);
    }

    @Override
    public List<String> delete(List<String> employeeIdList) {
        List<String> deletedIdList = new ArrayList<>();
        for (String employeeId : employeeIdList) {
            Optional<EmployeeEntity> entityOptional = employeeRepositoryJpa.getEmployeeEntityByEmployeeId(employeeId);
            if (entityOptional.isPresent()) {
                Long currentTime = System.currentTimeMillis();
                EmployeeEntity entity = entityOptional.get();
                entity.setStatus(Constrants.STATUS.INACTIVE);
                entity.setUpdateBy(Util.auth());
                entity.setUpdateTime(currentTime);
                employeeRepositoryJpa.save(entity);
                deletedIdList.add(entity.getEmployeeId());
            }
        }
        return deletedIdList;
    }

    @Override
    public Object getDtoById(String employeeId) {
        Optional<EmployeeEntityDto> entityOptional = employeeRepositoryJpa.getEmployeeEntityDtoByEmployeeId(employeeId);
        if (entityOptional.isPresent()) {
            EmployeeEntityDto employeeEntityDto = entityOptional.get();
            employeeEntityDto.setRoleEntityDtoList(employeeRoleRepositoryJpa.getRoleEntityDtoOfEmployeeId(employeeEntityDto.getEmployeeId()));
            return employeeEntityDto;
        }
        return entityOptional;
    }

    public Object login(EmployeeEntityDto dto) {
        Optional<EmployeeEntityDto> dtoOptional = employeeRepositoryJpa.getEmployeeEntityDtoByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(dtoOptional.isPresent()){
            dto = dtoOptional.get();
            dto.setRoleEntityDtoList(employeeRoleRepositoryJpa.getRoleEntityDtoOfEmployeeId(dto.getEmployeeId()));
            return dto;
        }
        return "Username or password incorrect";
    }
}
