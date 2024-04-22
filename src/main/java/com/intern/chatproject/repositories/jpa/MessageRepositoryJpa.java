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

    @Query("select count(m.messageId) from MessageEntity m where m.sendTime > :minTime and m.sendTime < :maxTime")
    long getCountMessage(long minTime, long maxTime);
    @Query("select count(m.messageId) from MessageEntity m " +
            "join ChatBoxEntity cb on m.chatBoxId = cb.chatBoxId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "where m.sendTime > :minTime and m.sendTime < :maxTime and w.websiteId = :websiteId")
    long getCountMessageOfWebsite(long minTime, long maxTime, String websiteId);
    boolean existsMessageEntityByMessageId(String messageId);
    Optional<MessageEntity> getMessageEntityByMessageId(String messageId);
}
