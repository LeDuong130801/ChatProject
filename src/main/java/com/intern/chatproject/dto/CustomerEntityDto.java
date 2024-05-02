package com.intern.chatproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntityDto {
    String customerId;
    String customerName;
    String oauthKey;
    String oauthToken;
    Short source;
    String phoneNumber;
    Short isOnline;
    String token;

    public CustomerEntityDto(String customerId, String customerName, String oauthKey, String oauthToken, Short source, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.oauthKey = oauthKey;
        this.oauthToken = oauthToken;
        this.source = source;
        this.phoneNumber = phoneNumber;
    }
}
