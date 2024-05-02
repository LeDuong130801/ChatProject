package com.intern.chatproject.dto;


import com.intern.chatproject.entities.RoleEntity;
import com.intern.chatproject.utils.Util;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntityDto {
    String roleId;
    String roleName;
    Short status;
    String createBy;
    Long createTime;
    String updateBy;
    Long updateTime;

}
