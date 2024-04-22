package com.intern.chatproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleUserInfo {
    private String type;
    private String credential;
    private String g_csrf_token;
}