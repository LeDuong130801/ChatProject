package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.MessageEntityDto;
import com.intern.chatproject.entities.MessageEntity;
import com.intern.chatproject.services.MessageService;
import com.intern.chatproject.services.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wsc")
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/send")
    public void sendMessage(@Payload MessageEntityDto dto) {
        MessageEntityDto savedMsg = (MessageEntityDto) messageService.send(dto);
        messagingTemplate.convertAndSendToUser(
                dto.getChatBoxId(), "/queue/messages",
                savedMsg
        );
    }

    @GetMapping("/box/{boxchat_id}/{sender_id}")
    public List<MessageEntityDto> getMessage(@PathVariable(value = "boxchat_id") String boxChatId, @PathVariable(value = "sender_id")String senderId) {
        return messageService.getMessageFromChatBox(boxChatId);
    }
}
