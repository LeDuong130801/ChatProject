package com.intern.chatproject.services;

import com.intern.chatproject.dto.MessageEntityDto;

import java.util.List;

public interface MessageService {
    Object send(MessageEntityDto dto);
    Object seen(String messageId);
    List<MessageEntityDto> getMessageFromChatBox(String chatBoxId);
}
