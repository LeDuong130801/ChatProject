package com.intern.chatproject.dto;


import com.intern.chatproject.entities.EmployeeEntity;
import com.intern.chatproject.utils.Util;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeEntityDto implements Serializable {
    String employeeId;
    String employeeName;
    String phoneNumber;
    String username;
    String password;
    String email;
    Short status;
    String createBy;
    Long createTime;
    String updateBy;
    Long updateTime;
    List<RoleEntityDto> roleEntityDtoList;
    String role;
    String roleName;
    Long webQuantity;
    String token;

    //    List<String> projectNameList;
    String updateTimeText;
    String createTimeText;

    public EmployeeEntityDto(String employeeId, String employeeName, String phoneNumber, String username, String password, Short status, String createBy, Long createTime, String updateBy, Long updateTime, String role) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.role = role;
    }

    public EmployeeEntityDto(String employeeId, String employeeName, String phoneNumber, String username, String password, String email, Short status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public EmployeeEntityDto(String employeeId, String employeeName, String phoneNumber, String username, String password, String email, Short status, String role, String roleName, Long webQuantity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.role = role;
        this.roleName = roleName;
        this.webQuantity = webQuantity;
    }
}

