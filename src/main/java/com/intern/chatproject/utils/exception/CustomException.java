package com.intern.chatproject.utils.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public class CustomException extends RuntimeException {
    private Integer codeError;
    private String message;
    public CustomException(int code, String mess) {
        super(mess);
        codeError = code;
        message = mess;
    }

    public CustomException(String mess) {
        super(mess);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public Integer getCodeError() {
        return codeError;
    }

    public ResponseEntity<?> return202(String message){
        return ResponseEntity.accepted().body(message);
    }
    public static ResponseEntity<?> noPermission(Integer code, String message){
        return ResponseEntity.badRequest().body(new CustomException(code, message));
    }
    public static ResponseEntity<?> error(Integer code, String message){
        return ResponseEntity.badRequest().body(new CustomErrorCode(code, message));
    }
 }
