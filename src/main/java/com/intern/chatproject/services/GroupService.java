package com.intern.chatproject.services;

import com.intern.chatproject.dto.GroupEntityDto;

public interface GroupService {
    Object create(GroupEntityDto dto);
    Object getById(String id);
}
