package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.MessageEntityDto;
import com.intern.chatproject.entities.MessageEntity;
import com.intern.chatproject.repositories.jpa.ChatBoxRepositoryJpa;
import com.intern.chatproject.repositories.jpa.MessageRepositoryJpa;
import com.intern.chatproject.services.MessageService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.Util;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                && chatBoxRepositoryJpa.existsChatBoxEntityByChatBoxIdAndCustomerId(dto.getChatBoxId(), dto.getSenderId())) {
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
        else throw new CustomException("Not Found Chat");
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
    public List<MessageEntityDto> getMessageByCustomerIdAndWebsiteName(String customerId, String websiteName) {
        return messageRepositoryJpa.getMessageEntityDtoByCustomerIdAndWebsiteName(customerId, websiteName);
    }

    @Override
    public Long getCountMessageFromMinTime2MaxTime(Long minTime, Long maxTime) {
        maxTime = maxTime == null ? Util.getStartDateToday()+Constrants.oneDayMilis : maxTime;
        return messageRepositoryJpa.getCountMessage(minTime, maxTime);
    }

    @Override
    public Long getCountMessageFromMinTime2MaxTimeAndWebsite(Long minTime, Long maxTime, String websiteId) {
        maxTime = maxTime == null ? Util.getStartDateToday()+Constrants.oneDayMilis : maxTime;
        return messageRepositoryJpa.getCountMessageOfWebsite(minTime, maxTime, websiteId);
    }

    public Long getCountMessageOfWebsiteOnThis(String str, String websiteId){
        return switch (str) {
            case "day" -> messageRepositoryJpa.getCountMessageOfWebsite(Util.getStartDateToday(), System.currentTimeMillis(), websiteId);
            case "week" -> messageRepositoryJpa.getCountMessageOfWebsite(Util.getStartDateThisWeek(), System.currentTimeMillis(), websiteId);
            case "month" -> messageRepositoryJpa.getCountMessageOfWebsite(Util.getStartDateThisMonth(), System.currentTimeMillis(), websiteId);
            case "year" -> messageRepositoryJpa.getCountMessageOfWebsite(Util.getStartDateThisYear(), System.currentTimeMillis(), websiteId);
            default -> 0L;
        };
    }
    public Long getCountMessageOfWebsiteOnBetween(Integer fromDay, Integer fromMonth, Integer fromYear, Integer toDay, Integer toMonth, Integer toYear, String websiteId){
        fromDay = fromDay == null ? 1 : fromDay;
        fromMonth = fromMonth == null ? 1 : fromMonth;
        fromYear = fromYear == null ? new Date().getYear()+1900 : fromYear;
        toDay = toDay == null ? 1 : toDay;
        toMonth = toMonth == null ? 1 : toMonth;
        toYear = toYear == null ? new Date().getYear()+1900 : toYear;
        return messageRepositoryJpa.getCountMessageOfWebsite(Util.getStartOf(fromDay, fromMonth, fromYear), Util.getStartOf(toDay, toMonth, toYear), websiteId);
    }

    public Long getCountMessageOnThis(String str){
        return switch (str) {
            case "day" -> messageRepositoryJpa.getCountMessage(Util.getStartDateToday(), System.currentTimeMillis());
            case "week" -> messageRepositoryJpa.getCountMessage(Util.getStartDateThisWeek(), System.currentTimeMillis());
            case "month" -> messageRepositoryJpa.getCountMessage(Util.getStartDateThisMonth(), System.currentTimeMillis());
            case "year" -> messageRepositoryJpa.getCountMessage(Util.getStartDateThisYear(), System.currentTimeMillis());
            default -> 0L;
        };
    }
    public Long getCountMessageOnBetween(Integer fromDay, Integer fromMonth, Integer fromYear, Integer toDay, Integer toMonth, Integer toYear){
        fromDay = fromDay == null ? 1 : fromDay;
        fromMonth = fromMonth == null ? 1 : fromMonth;
        fromYear = fromYear == null ? new Date().getYear()+1900 : fromYear;
        toDay = toDay == null ? 1 : toDay;
        toMonth = toMonth == null ? 1 : toMonth;
        toYear = toYear == null ? new Date().getYear()+1900 : toYear;
        return messageRepositoryJpa.getCountMessage(Util.getStartOf(fromDay, fromMonth, fromYear), Util.getStartOf(toDay, toMonth, toYear));
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
