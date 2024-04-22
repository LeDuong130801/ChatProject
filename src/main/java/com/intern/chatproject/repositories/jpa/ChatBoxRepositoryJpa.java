package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.ChatBoxEntityDto;
import com.intern.chatproject.entities.ChatBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatBoxRepositoryJpa extends JpaRepository<ChatBoxEntity, String> {
    boolean existsChatBoxEntityByChatBoxId(String chatBoxId);
    boolean existsChatBoxEntityByChatBoxIdAndCustomerId(String chatBoxId, String customerId);
    boolean existsChatBoxEntityByCustomerId(String customerId);
    boolean existsChatBoxEntityByChatBoxIdAndEmployeeId(String chatBoxId, String employeeId);

    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "cb.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join EmployeeEntity e on cb.employeeId = e.employeeId " +
            "join CustomerEntity ua on cb.customerId = ua.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "where cb.employeeId = :employeeId")
    List<ChatBoxEntityDto> getChatBoxEntityDtoByEmployeeId(String employeeId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "cb.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join EmployeeEntity e on cb.employeeId = e.employeeId " +
            "join CustomerEntity ua on cb.customerId = ua.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "where cb.chatBoxId = :chatBoxId")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByChatBoxId(String chatBoxId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "cb.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join EmployeeEntity e on cb.employeeId = e.employeeId " +
            "join CustomerEntity ua on cb.customerId = ua.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "where ua.customerId = :customerId")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByCustomerId(String customerId);
}
