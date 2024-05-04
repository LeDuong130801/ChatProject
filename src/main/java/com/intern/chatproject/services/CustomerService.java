package com.intern.chatproject.services;

import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.GoogleUserInfo;
import com.intern.chatproject.services.impl.TokenServiceImpl;

public interface CustomerService {
    Object create(CustomerEntityDto dto, String websiteOrigin, TokenServiceImpl tokenService);
    Object edit(CustomerEntityDto dto);
    Object changePassword(CustomerEntityDto dto);
    Object login(CustomerEntityDto dto, String websiteOrigin, TokenServiceImpl tokenService);
    Object login(GoogleUserInfo googleUserInfo, String websiteOrigin, TokenServiceImpl tokenService);
    Object forgotPassword(CustomerEntityDto dto);
}
