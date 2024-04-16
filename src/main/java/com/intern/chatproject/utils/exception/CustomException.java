package com.intern.chatproject.utils.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public class CustomException extends RuntimeException {
    private Integer codeError;
    public CustomException(int code, String mess) {
        super(mess);
        codeError = code;
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
 }
