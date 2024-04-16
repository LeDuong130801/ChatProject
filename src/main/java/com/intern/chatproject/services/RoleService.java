package com.intern.chatproject.services;

import com.intern.chatproject.dto.RoleEntityDto;

import java.util.List;


public interface RoleService {
    Object create(RoleEntityDto dto);
    Object edit(RoleEntityDto dto);
    List<String> delete(List<String> roleIdList);
}
