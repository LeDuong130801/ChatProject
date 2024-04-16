package com.intern.chatproject.dto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAccountDto {
    String userAccountId;
    String userAccountName;
    String email;
    String password;
    String authKey;
    Short source;
    String deviceId;
    Short status;

    String newPassword;

    public UserAccountDto(String userAccountId, String userAccountName, String email, String password, String authKey, Short source, String deviceId, Short status) {
        this.userAccountId = userAccountId;
        this.userAccountName = userAccountName;
        this.email = email;
        this.password = password;
        this.authKey = authKey;
        this.source = source;
        this.deviceId = deviceId;
        this.status = status;
    }
}
