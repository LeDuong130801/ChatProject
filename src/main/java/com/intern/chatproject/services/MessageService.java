package com.intern.chatproject.services;

import com.intern.chatproject.dto.MessageEntityDto;

import java.util.List;

public interface MessageService {
    Object send(MessageEntityDto dto);
    Object seen(String messageId);
    List<MessageEntityDto> getMessageFromChatBox(String chatBoxId);
    List<MessageEntityDto> getMessageByCustomerIdAndWebsiteName(String customerId, String websiteName);
    Long getCountMessageFromMinTime2MaxTime(Long minTime, Long maxTime);
    Long getCountMessageFromMinTime2MaxTimeAndWebsite(Long minTime, Long maxTime, String websiteId);
}
