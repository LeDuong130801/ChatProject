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
    public static RoleEntityDto parseEntity(RoleEntity entity){
        RoleEntityDto dto = RoleEntityDto.builder()
                .roleId(entity.getRoleId())
                .roleName(entity.getRoleName())
                .status(entity.getStatus())
                .createBy(entity.getCreateBy())
                .createTime(entity.getCreateTime())
                .updateBy(entity.getUpdateBy())
                .updateTime(entity.getUpdateTime())
                .build();
        dto.parseCreateTimeText();
        dto.parseUpdateTimeText();
        return dto;
    }

    public RoleEntityDto(String roleId, String roleName, Short status, String createBy, Long createTime, String updateBy, Long updateTime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }
}
