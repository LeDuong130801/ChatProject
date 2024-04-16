package com.intern.chatproject.dto;

import com.intern.chatproject.entities.MessageEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatBoxEntityDto {
    String chatBoxId;
    String chatBoxName;
    String userAccountId;
    String employeeId;
    Long lastChatTime;
    Short status;

    String userAccountName;
    String employeeName;
    List<MessageEntity> messageList;

    public ChatBoxEntityDto(String chatBoxId, String chatBoxName, String userAccountId, String employeeId, Long lastChatTime, Short status) {
        this.chatBoxId = chatBoxId;
        this.chatBoxName = chatBoxName;
        this.userAccountId = userAccountId;
        this.employeeId = employeeId;
        this.lastChatTime = lastChatTime;
        this.status = status;
    }

    public ChatBoxEntityDto(String chatBoxId, String chatBoxName, String userAccountId, String employeeId, Long lastChatTime, Short status, String userAccountName, String employeeName) {
        this.chatBoxId = chatBoxId;
        this.chatBoxName = chatBoxName;
        this.userAccountId = userAccountId;
        this.employeeId = employeeId;
        this.lastChatTime = lastChatTime;
        this.status = status;
        this.userAccountName = userAccountName;
        this.employeeName = employeeName;
    }
}
