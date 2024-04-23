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
    String customerId;
    String employeeId;
    Short allowGuest;

    String customerName;
    String employeeName;
    String websiteId;
    String websiteName;
    List<MessageEntity> messageList;

    public ChatBoxEntityDto(String chatBoxId, String chatBoxName, String customerId, String employeeId, Short allowGuest) {
        this.chatBoxId = chatBoxId;
        this.chatBoxName = chatBoxName;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.allowGuest = allowGuest;
    }

    public ChatBoxEntityDto(String chatBoxId, String chatBoxName, String customerId, String employeeId, Short allowGuest, String customerName, String employeeName) {
        this.chatBoxId = chatBoxId;
        this.chatBoxName = chatBoxName;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.allowGuest = allowGuest;
        this.customerName = customerName;
        this.employeeName = employeeName;
    }

    public ChatBoxEntityDto(String chatBoxId, String chatBoxName, String customerId, String employeeId, Short allowGuest, String customerName, String employeeName, String websiteId, String websiteName) {
        this.chatBoxId = chatBoxId;
        this.chatBoxName = chatBoxName;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.allowGuest = allowGuest;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.websiteId = websiteId;
        this.websiteName = websiteName;
    }
}
