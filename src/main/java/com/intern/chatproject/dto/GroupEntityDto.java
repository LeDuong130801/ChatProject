package com.intern.chatproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupEntityDto {
    String groupId;
    String groupName;
    Short allowGuest;
    String employeeId;
    List<WebsiteEntityDto> websiteEntityDtoList;

    public GroupEntityDto(String groupId, String groupName, Short allowGuest, String employeeId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.allowGuest = allowGuest;
        this.employeeId = employeeId;
    }
}
