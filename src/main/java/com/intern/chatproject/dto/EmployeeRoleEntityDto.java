package com.intern.chatproject.dto;


import com.intern.chatproject.utils.Util;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRoleEntityDto {
    String employeeRoleId;
    String employeeId;
    String roleId;

    String employeeName;
    String phoneNumber;
    String username;
    String password;

    String roleName;

    Short status;
    String createBy;
    Long createTime;
    String updateBy;
    Long updateTime;

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

    public EmployeeRoleEntityDto(String employeeRoleId, String employeeId, String roleId, String employeeFullname, String phoneNumber, String username, String password, String roleName) {
        this.employeeRoleId = employeeRoleId;
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.employeeName = employeeFullname;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }
}
