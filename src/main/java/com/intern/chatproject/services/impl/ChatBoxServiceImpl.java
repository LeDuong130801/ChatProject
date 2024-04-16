package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.ChatBoxEntityDto;
import com.intern.chatproject.entities.ChatBoxEntity;
import com.intern.chatproject.repositories.jpa.ChatBoxRepositoryJpa;
import com.intern.chatproject.services.ChatBoxService;
import com.intern.chatproject.utils.Util;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ChatBoxServiceImpl implements ChatBoxService {

    @Autowired
    ChatBoxRepositoryJpa chatBoxRepositoryJpa;

    @Override
    public Object create(String userAccountId) {
        if (chatBoxRepositoryJpa.existsChatBoxEntityDtoByUserAccountId(userAccountId)){
            return chatBoxRepositoryJpa.getChatBoxEntityDtoByUserAccountId(userAccountId);
        }
        ChatBoxEntity entity = ChatBoxEntity.builder()
                .chatBoxId(UUID.randomUUID().toString())
                .chatBoxName(userAccountId)
                .userAccountId(userAccountId)
                .employeeId(Util.employeeSaleId())
                .lastChatTime(System.currentTimeMillis())
                .build();
        return chatBoxRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(ChatBoxEntityDto dto) {
        if (chatBoxRepositoryJpa.existsChatBoxEntityByChatBoxId(dto.getChatBoxId())){
            ChatBoxEntity entity = ChatBoxEntity.builder()
                    .chatBoxId(UUID.randomUUID().toString())
                    .chatBoxName(dto.getUserAccountId())
                    .userAccountId(dto.getChatBoxName())
                    .employeeId(Util.employeeSaleId())
                    .lastChatTime(System.currentTimeMillis())
                    .build();
            return chatBoxRepositoryJpa.save(entity);
        }
        throw new CustomException("No chat box id: "+dto.getChatBoxId());
    }
}
