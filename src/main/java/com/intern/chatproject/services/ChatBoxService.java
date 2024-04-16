package com.intern.chatproject.services;

import com.intern.chatproject.dto.ChatBoxEntityDto;

public interface ChatBoxService {
    Object create(String userAccountId);
    Object edit(ChatBoxEntityDto dto);
}
