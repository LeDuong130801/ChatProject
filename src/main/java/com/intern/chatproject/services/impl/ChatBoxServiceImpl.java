package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.ChatBoxEntityDto;
import com.intern.chatproject.entities.ChatBoxEntity;
import com.intern.chatproject.repositories.jpa.ChatBoxRepositoryJpa;
import com.intern.chatproject.repositories.jpa.MessageRepositoryJpa;
import com.intern.chatproject.services.ChatBoxService;
import com.intern.chatproject.utils.Util;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatBoxServiceImpl implements ChatBoxService {

    @Autowired
    ChatBoxRepositoryJpa chatBoxRepositoryJpa;
    @Autowired
    MessageRepositoryJpa messageRepositoryJpa;

    @Override
    public Object create(String customerId) {
        if (chatBoxRepositoryJpa.existsChatBoxEntityByCustomerId(customerId)) {
            return chatBoxRepositoryJpa.getChatBoxEntityDtoByCustomerId(customerId);
        }
        ChatBoxEntity entity = ChatBoxEntity.builder()
                .chatBoxId(UUID.randomUUID().toString())
                .chatBoxName(customerId)
                .customerId(customerId)
                .build();
        return chatBoxRepositoryJpa.save(entity);
    }

    public Object create(String customerId, String websiteName) {
        Optional<ChatBoxEntityDto> chatBoxEntityDto = chatBoxRepositoryJpa.getChatBoxEntityDtoByCustomerIdAndWebsiteName(customerId, websiteName);
        if (chatBoxEntityDto.isPresent()){
            return chatBoxEntityDto.get();
        }
        ChatBoxEntity entity = ChatBoxEntity.builder()
                .chatBoxId(UUID.randomUUID().toString())
                .chatBoxName(customerId)
                .customerId(customerId)
                .build();
        return chatBoxRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(ChatBoxEntityDto dto) {
        if (chatBoxRepositoryJpa.existsChatBoxEntityByChatBoxId(dto.getChatBoxId())) {
            ChatBoxEntity entity = ChatBoxEntity.builder()
                    .chatBoxId(UUID.randomUUID().toString())
                    .chatBoxName(dto.getCustomerName())
                    .customerId(dto.getChatBoxName())
                    .build();
            return chatBoxRepositoryJpa.save(entity);
        }
        throw new CustomException("No chat box id: " + dto.getChatBoxId());
    }

    public Object getChatBoxOfCustomer(String customerId) {
        return chatBoxRepositoryJpa.getChatBoxEntityDtoByCustomerId(customerId);
    }

    public Object getChatBoxOfEmployee(String employeeId) {
        return chatBoxRepositoryJpa.getChatBoxEntityDtoByEmployeeId(employeeId);
    }

    public Object filterByEmployeeIdAndCustomerIdAndWebsiteId(String employeeId, String customerId, String websiteId) {
        return chatBoxRepositoryJpa.filterByEmployeeIdAndCustomerIdAndWebsiteId(employeeId, customerId, websiteId);
    }

    public Object getAllChatBoxDetailOfEmployee(String websiteOrigin, String websiteName, String employeeId) {
        List<ChatBoxEntityDto> chatBoxEntityDtoList = chatBoxRepositoryJpa.filterByWebsiteOriginAndWebsiteNameAndEmployeeId(websiteOrigin, websiteName, employeeId);
        for (ChatBoxEntityDto chatBoxEntityDto : chatBoxEntityDtoList) {
            chatBoxEntityDto.setMessageList(messageRepositoryJpa.getMessageEntityDtoByChatBoxId(chatBoxEntityDto.getChatBoxId()));
        }
        return chatBoxEntityDtoList;
    }

    public Object getChatBoxDetailOfCustomer(String websiteId, String websiteName, String customerId) {
        List<ChatBoxEntityDto> chatBoxEntityDtoList = chatBoxRepositoryJpa.filterByWebsiteOriginAndWebsiteNameAndCustomerId(websiteId, websiteName, customerId);
        for (ChatBoxEntityDto chatBoxEntityDto : chatBoxEntityDtoList) {
            chatBoxEntityDto.setMessageList(messageRepositoryJpa.getMessageEntityDtoByChatBoxId(chatBoxEntityDto.getChatBoxId()));
        }
        return chatBoxEntityDtoList;
    }
}
