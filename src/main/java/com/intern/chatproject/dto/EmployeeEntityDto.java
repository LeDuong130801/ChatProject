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
    Short status;
    String createBy;
    Long createTime;
    String updateBy;
    Long updateTime;
    List<RoleEntityDto> roleEntityDtoList;
    String role;

    //    List<String> projectNameList;
    String updateTimeText;
    String createTimeText;
    public String parseUpdateTimeText(){
        updateTimeText = Util.dateTime2DateString(updateTime);
        return updateTimeText;
    }
    public String parseCreateTimeText(){
        createTimeText = Util.dateTime2DateString(createTime);
        return createTimeText;
    }
    public static EmployeeEntityDto parseEntity(EmployeeEntity entity){
        EmployeeEntityDto dto = EmployeeEntityDto.builder()
                .employeeId(entity.getEmployeeId())
                .employeeName(entity.getEmployeeName())
                .phoneNumber(entity.getPhoneNumber())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .status(entity.getStatus())
                .createBy(entity.getCreateBy())
                .createTime(entity.getCreateTime())
                .updateBy(entity.getUpdateBy())
                .updateTime(entity.getUpdateTime()).build();
        dto.parseCreateTimeText();
        dto.parseUpdateTimeText();
        return dto;
    }

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

    public EmployeeEntityDto(String employeeId, String employeeName, String phoneNumber, String username, String password, Short status, List<RoleEntityDto> roleEntityDtoList) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.status = status;
        this.roleEntityDtoList = roleEntityDtoList;
    }
    public EmployeeEntityDto(String employeeId, String employeeName, String phoneNumber, String username, String password, Short status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.status = status;
    }
}

