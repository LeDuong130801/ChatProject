package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.WebsiteEntityDto;
import com.intern.chatproject.entities.WebsiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WebsiteRepositoryJpa extends JpaRepository<WebsiteEntity, String> {
    boolean existsWebsiteEntityByWebsiteId(String websiteId);
    boolean existsWebsiteEntityByChatBoxId(String chatBoxId);
    @Query("select new com.intern.chatproject.dto.WebsiteEntityDto(" +
            "w.websiteId, " +
            "w.websiteName," +
            "w.chatBoxId, " +
            "cb.allowGuest) " +
            "from WebsiteEntity w " +
            "join ChatBoxEntity cb on w.chatBoxId = cb.chatBoxId " +
            "where w.websiteId = :websiteId")
    Optional<WebsiteEntityDto> getWebsiteEntityDtoByWebsiteId(String websiteId);
    @Query("select new com.intern.chatproject.dto.WebsiteEntityDto(" +
            "w.websiteId, " +
            "w.websiteName," +
            "w.chatBoxId, " +
            "cb.allowGuest) " +
            "from WebsiteEntity w " +
            "join ChatBoxEntity cb on w.chatBoxId = cb.chatBoxId " +
            "where w.chatBoxId = :chatBoxId")
    Optional<WebsiteEntityDto> getWebsiteEntityDtoByChatBoxId(String chatBoxId);

}
