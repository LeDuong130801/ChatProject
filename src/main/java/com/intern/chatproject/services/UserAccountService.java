package com.intern.chatproject.services;

import com.intern.chatproject.dto.UserAccountDto;

public interface UserAccountService {
    Object create(UserAccountDto dto);
    Object edit(UserAccountDto dto);
    Object changePassword(UserAccountDto dto);
}
