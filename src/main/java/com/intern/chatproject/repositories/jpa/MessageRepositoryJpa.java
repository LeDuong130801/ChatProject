package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.ChatBoxEntityDto;
import com.intern.chatproject.dto.MessageEntityDto;
import com.intern.chatproject.entities.MessageEntity;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepositoryJpa extends JpaRepository<MessageEntity, String> {
    @Query("select new com.intern.chatproject.dto.MessageEntityDto(" +
            "m.messageId, " +
            "m.messageContent, " +
            "m.messageType," +
            "m.sendTime," +
            "m.status," +
            "m.chatBoxId) " +
            "from MessageEntity m where m.chatBoxId = :chatBoxId order by m.sendTime desc")
    List<MessageEntityDto> getMessageEntityDtoByChatBoxId(String chatBoxId);

    @Query("select new com.intern.chatproject.dto.MessageEntityDto(" +
            "m.messageId, " +
            "m.messageContent, " +
            "m.messageType," +
            "m.sendTime," +
            "m.status," +
            "m.chatBoxId) " +
            "from MessageEntity m " +
            "join ChatBoxEntity cb on cb.chatBoxId = m.chatBoxId " +
            "where cb.customerId = :customerId order by m.sendTime desc")
    List<MessageEntityDto> getMessageEntityDtoByCustomerId(String customerId);

    boolean existsMessageEntityByMessageId(String messageId);
    Optional<MessageEntity> getMessageEntityByMessageId(String messageId);
}
