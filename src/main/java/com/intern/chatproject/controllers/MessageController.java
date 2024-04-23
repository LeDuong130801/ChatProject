package com.intern.chatproject.controllers;

import com.intern.chatproject.dto.MessageEntityDto;
import com.intern.chatproject.entities.MessageEntity;
import com.intern.chatproject.services.MessageService;
import com.intern.chatproject.services.impl.MessageServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageEntityDto dto) {
        MessageEntity savedMsg = (MessageEntity) messageService.send(dto);
        messagingTemplate.convertAndSend(
                "/topic/messages/" + to, savedMsg
        );
    }

    @GetMapping("/box/{boxchat_id}/{sender_id}")
    public List<MessageEntityDto> getMessage(@PathVariable(value = "boxchat_id") String boxChatId, @PathVariable(value = "sender_id") String senderId) {
        return messageService.getMessageFromChatBox(boxChatId);
    }

    @GetMapping("/api/message/website/count")
    public long getCountMessage(
            @RequestParam(value = "from_day", required = false) Integer fromDay,
            @RequestParam(value = "from_month", required = false) Integer fromMonth,
            @RequestParam(value = "from_year", required = false) Integer fromYear,
            @RequestParam(value = "to_day", required = false) Integer toDay,
            @RequestParam(value = "to_month", required = false) Integer toMonth,
            @RequestParam(value = "to_year", required = false) Integer toYear,
            @RequestParam(value = "website_id") String websiteId) {
        return messageService.getCountMessageOfWebsiteOnBetween(fromDay, fromMonth, fromYear, toDay, toMonth, toYear, websiteId);
    }

    @GetMapping("/api/message/website/count/{option}")
    public long getCountMessageOption(@PathVariable(value = "option") String option, @RequestParam(value = "website_id") String websiteId){
        return messageService.getCountMessageOfWebsiteOnThis(option, websiteId);
    }

    @GetMapping("/api/message/count")
    public long getCountMessage(
            @RequestParam(value = "from_day", required = false) Integer fromDay,
            @RequestParam(value = "from_month", required = false) Integer fromMonth,
            @RequestParam(value = "from_year", required = false) Integer fromYear,
            @RequestParam(value = "to_day", required = false) Integer toDay,
            @RequestParam(value = "to_month", required = false) Integer toMonth,
            @RequestParam(value = "to_year", required = false) Integer toYear) {
        return messageService.getCountMessageOnBetween(fromDay, fromMonth, fromYear, toDay, toMonth, toYear);
    }
    @GetMapping("/api/message/count/{option}")
    public long getCountMessageOption(@PathVariable(value = "option") String option){
        return messageService.getCountMessageOnThis(option);
    }
}
