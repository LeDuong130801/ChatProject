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
    boolean existsChatBoxEntityByChatBoxIdAndUserAccountId(String chatBoxId, String userAccountId);
    boolean existsChatBoxEntityByChatBoxIdAndEmployeeId(String chatBoxId, String employeeId);

    @Query("SELECT CASE WHEN COUNT(cb) > 0 THEN true ELSE false END from ChatBoxEntity cb WHERE cb.userAccountId = :userAccountId")
    boolean existsChatBoxEntityDtoByUserAccountId(String userAccountId);

    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.userAccountId," +
            "cb.employeeId," +
            "cb.lastChatTime," +
            "cb.status," +
            "ua.userAccountName," +
            "e.employeeFullname) " +
            "from ChatBoxEntity cb " +
            "join EmployeeEntity e on cb.employeeId = e.employeeId " +
            "join UserAccountEntity ua on cb.userAccountId = ua.userAccountId " +
            "where cb.employeeId = :employeeId")
    List<ChatBoxEntityDto> getChatBoxEntityDtoByEmployeeId(String employeeId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.userAccountId," +
            "cb.employeeId," +
            "cb.lastChatTime," +
            "cb.status," +
            "ua.userAccountName," +
            "e.employeeFullname) " +
            "from ChatBoxEntity cb " +
            "join EmployeeEntity e on cb.employeeId = e.employeeId " +
            "join UserAccountEntity ua on cb.userAccountId = ua.userAccountId " +
            "where cb.chatBoxId = :chatBoxId")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByChatBoxId(String chatBoxId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.userAccountId," +
            "cb.employeeId," +
            "cb.lastChatTime," +
            "cb.status," +
            "ua.userAccountName," +
            "e.employeeFullname) " +
            "from ChatBoxEntity cb " +
            "join EmployeeEntity e on cb.employeeId = e.employeeId " +
            "join UserAccountEntity ua on cb.userAccountId = ua.userAccountId " +
            "where ua.userAccountId = :userAccountId")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByUserAccountId(String userAccountId);
}
