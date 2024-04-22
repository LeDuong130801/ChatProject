package com.intern.chatproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebsiteEntityDto {
    String websiteId;
    String websiteName;
    String websiteKey;
    Long showFrom;
    String groupId;
    Short allowGuest;

    String groupName;

    public WebsiteEntityDto(String websiteId, String websiteName, String websiteKey, String groupId, Short allowGuest) {
        this.websiteId = websiteId;
        this.websiteName = websiteName;
        this.websiteKey = websiteKey;
        this.groupId = groupId;
        this.allowGuest = allowGuest;
    }
}
