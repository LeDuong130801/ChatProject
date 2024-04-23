package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.WebsiteEntityDto;
import com.intern.chatproject.entities.WebsiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebsiteRepositoryJpa extends JpaRepository<WebsiteEntity, String> {
    boolean existsWebsiteEntityByWebsiteId(String websiteId);
    @Query("select new com.intern.chatproject.dto.WebsiteEntityDto(" +
            "w.websiteId, " +
            "w.websiteName," +
            "w.websiteKey, " +
            "w.groupId," +
            "g.allowGuest) " +
            "from WebsiteEntity w " +
            "join GroupEntity g on w.groupId = g.groupId " +
            "where w.websiteId = :websiteId")
    Optional<WebsiteEntityDto> getWebsiteEntityDtoByWebsiteId(String websiteId);
    @Query("select new com.intern.chatproject.dto.WebsiteEntityDto(" +
            "w.websiteId, " +
            "w.websiteName," +
            "w.websiteKey, " +
            "w.groupId," +
            "g.allowGuest) " +
            "from WebsiteEntity w " +
            "join GroupEntity g on w.groupId = g.groupId " +
            "where w.websiteName = :websiteName")
    Optional<WebsiteEntityDto> getWebsiteEntityDtoByWebsiteName(String websiteName);
    @Query("select new com.intern.chatproject.dto.WebsiteEntityDto(" +
            "w.websiteId, " +
            "w.websiteName," +
            "w.websiteKey, " +
            "w.groupId," +
            "g.allowGuest) " +
            "from WebsiteEntity w " +
            "join GroupEntity g on w.groupId = g.groupId " +
            "where w.groupId = :groupId")
    List<WebsiteEntityDto> getWebsiteEntityDtoByGroupId(String groupId);

}
