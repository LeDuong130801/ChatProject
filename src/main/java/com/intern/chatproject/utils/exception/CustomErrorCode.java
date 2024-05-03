package com.intern.chatproject.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomErrorCode {
    private Integer errorCode;
    private String message;
    private Long responseTime;
    public CustomErrorCode(){}
    public CustomErrorCode(Integer errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
        this.responseTime = System.currentTimeMillis();
    }
}
