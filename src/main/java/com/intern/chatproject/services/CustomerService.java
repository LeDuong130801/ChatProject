package com.intern.chatproject.services;

import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.GoogleUserInfo;

public interface CustomerService {
    Object create(CustomerEntityDto dto);
    Object edit(CustomerEntityDto dto);
    Object changePassword(CustomerEntityDto dto);
    Object login(CustomerEntityDto dto);
    Object login(GoogleUserInfo googleUserInfo);
    Object forgotPassword(CustomerEntityDto dto);
}
