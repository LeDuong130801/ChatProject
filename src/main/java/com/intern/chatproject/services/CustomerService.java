package com.intern.chatproject.services;

import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.GoogleUserInfo;
import com.intern.chatproject.services.impl.TokenServiceImpl;

public interface CustomerService {
    Object create(CustomerEntityDto dto, TokenServiceImpl tokenService);
    Object edit(CustomerEntityDto dto);
    Object changePassword(CustomerEntityDto dto);
    Object login(CustomerEntityDto dto, TokenServiceImpl tokenService);
    Object login(GoogleUserInfo googleUserInfo, TokenServiceImpl tokenService);
    Object forgotPassword(CustomerEntityDto dto);
}
