package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.MessageEntityDto;
import com.intern.chatproject.entities.MessageEntity;
import com.intern.chatproject.repositories.jpa.ChatBoxRepositoryJpa;
import com.intern.chatproject.repositories.jpa.MessageRepositoryJpa;
import com.intern.chatproject.services.MessageService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    ChatBoxRepositoryJpa chatBoxRepositoryJpa;
    @Autowired
    MessageRepositoryJpa messageRepositoryJpa;

    @Override
    public Object send(MessageEntityDto dto) {
        if (dto.getMessageType().equals(Constrants.MESSAGE_TYPE.CUSTOMER_SEND)
                && chatBoxRepositoryJpa.existsChatBoxEntityByChatBoxIdAndUserAccountId(dto.getChatBoxId(), dto.getSenderId())) {
            Long currentTime = System.currentTimeMillis();
            MessageEntity entity = MessageEntity.builder()
                    .chatBoxId(dto.getChatBoxId())
                    .messageId(dto.getChatBoxId() + currentTime + generatorRandom())
                    .messageType(dto.getMessageType())
                    .messageContent(dto.getMessageContent())
                    .status(Constrants.MESSAGE_STATUS.SENT)
                    .sendTime(currentTime)
                    .build();
            return messageRepositoryJpa.save(entity);
        } else if (dto.getMessageType().equals(Constrants.MESSAGE_TYPE.EMPLOYEE_SEND)
                && chatBoxRepositoryJpa.existsChatBoxEntityByChatBoxIdAndEmployeeId(dto.getChatBoxId(), dto.getSenderId())) {
            Long currentTime = System.currentTimeMillis();
            MessageEntity entity = MessageEntity.builder()
                    .chatBoxId(dto.getChatBoxId())
                    .messageId(dto.getChatBoxId() + currentTime + generatorRandom())
                    .messageType(dto.getMessageType())
                    .messageContent(dto.getMessageContent())
                    .status(Constrants.MESSAGE_STATUS.SENT)
                    .sendTime(currentTime)
                    .build();
            return messageRepositoryJpa.save(entity);
        }
        throw new CustomException("Not Found Chat");
    }

    @Override
    public Object seen(String messageId) {
        Optional<MessageEntity> entityOptional = messageRepositoryJpa.getMessageEntityByMessageId((messageId));
        if (entityOptional.isPresent()){
            MessageEntity entity = entityOptional.get();
            entity.setStatus(Constrants.MESSAGE_STATUS.SEEN);
            messageRepositoryJpa.save(entity);
        }
        throw new CustomException("Not found message");
    }

    @Override
    public List<MessageEntityDto> getMessageFromChatBox(String chatBoxId) {
        return messageRepositoryJpa.getMessageEntityDtoByChatBoxId(chatBoxId);
    }

    @Override
    public List<MessageEntityDto> getMessageByUserAccountId(String userAccountId) {
        return messageRepositoryJpa.getMessageEntityDtoByUserAccountId(userAccountId);
    }

    private String generatorRandom() {
        int leftLimit = 97;
        int rightLimit = 122;
        int ul = 'A';
        int ur = 'Z';
        int targetStringLength = 32;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        int randomLimitedInt = 0;
        for (int i = 0; i < targetStringLength; i++) {
            int r = random.nextInt() % 3;
            if (r == 0) {
                randomLimitedInt = ul + (int)
                        (random.nextFloat() * (ur - ul + 1));
            } else if (r == 1) {
                randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
            } else if (r == 2) {
                randomLimitedInt = 48 + (int)
                        (random.nextFloat() * (9));
            }
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
