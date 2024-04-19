package com.intern.chatproject.services;

import com.intern.chatproject.dto.CustomerEntityDto;

public interface CustomerService {
    Object create(CustomerEntityDto dto);
    Object edit(CustomerEntityDto dto);
    Object changePassword(CustomerEntityDto dto);
    Object login(CustomerEntityDto dto);
    Object forgotPassword(CustomerEntityDto dto);
}
