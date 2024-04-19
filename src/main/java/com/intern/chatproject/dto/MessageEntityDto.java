package com.intern.chatproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageEntityDto {
    String messageId;
    String messageContent;
    Short  messageType;
    Long   sendTime;
    Short  status;
    String chatBoxId;

    String senderId;

    public MessageEntityDto(String messageId, String messageContent, Short messageType, Long sendTime, Short status, String chatBoxId) {
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.messageType = messageType;
        this.sendTime = sendTime;
        this.status = status;
        this.chatBoxId = chatBoxId;
    }
}
