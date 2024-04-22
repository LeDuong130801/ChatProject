package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.GroupEntityDto;
import com.intern.chatproject.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupRepositoryJpa extends JpaRepository<GroupEntity, String> {
    boolean existsGroupEntityByGroupId(String groupId);
    Optional<GroupEntity> getGroupEntityByGroupId(String groupId);

    @Query("select new com.intern.chatproject.dto.GroupEntityDto(" +
            "g.groupId," +
            "g.groupName," +
            "g.allowGuest" +
            ") from GroupEntity g " +
            "where g.groupId = :groupId")
    Optional<GroupEntityDto> getGroupEntityDtoByGroupId(String groupId);
}
