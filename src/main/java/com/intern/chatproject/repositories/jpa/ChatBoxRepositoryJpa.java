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

    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest," +
            "c.customerName," +
            "e.employeeName," +
            "w.websiteId," +
            "w.websiteName," +
            "g.groupId," +
            "g.groupName " +
            ") from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where (:employee is null or g.employeeId = :employeeId) " +
            "and (:customerId is null or cb.customerId = :customerId) " +
            "and (:websiteId is null or w.websiteId = :websiteId) ")
    List<ChatBoxEntityDto> filterByEmployeeIdAndCustomerIdAndWebsiteId(String employeeId, String customerId, String websiteId);

    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where g.employeeId = :employeeId")
    List<ChatBoxEntityDto> getChatBoxEntityDtoByEmployeeId(String employeeId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where cb.chatBoxId = :chatBoxId")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByChatBoxId(String chatBoxId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where c.customerId = :customerId")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByCustomerId(String customerId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where c.customerId = :customerId " +
            "and w.websiteName = :websiteName")
    Optional<ChatBoxEntityDto> getChatBoxEntityDtoByCustomerIdAndWebsiteName(String customerId, String websiteName);

    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest) " +
            "from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where (:customerName is null or c.customerName like %:customerName%) " +
            "and (:websiteId is null or w.websiteId = :websiteId) " +
            "and (:employeeId is null or g.employeeId = :employeeId)")
    List<ChatBoxEntityDto> filterByCustomerNameAndWebsiteId(String customerName, String websiteId, String employeeId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest," +
            "c.customerName," +
            "e.employeeName," +
            "w.websiteId," +
            "w.websiteName," +
            "g.groupId," +
            "g.groupName " +
            ") from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where (:websiteName is null or w.websiteName like %:websiteName%) " +
            "and (:websiteOrigin is null or w.websiteOrigin = :websiteOrigin) " +
            "and (:employeeId is null or g.employeeId = :employeeId)")
    List<ChatBoxEntityDto> filterByWebsiteOriginAndWebsiteNameAndEmployeeId(String websiteOrigin, String websiteName, String employeeId);
    @Query("select new com.intern.chatproject.dto.ChatBoxEntityDto(" +
            "cb.chatBoxId," +
            "cb.chatBoxName," +
            "cb.customerId," +
            "g.employeeId," +
            "g.allowGuest," +
            "c.customerName," +
            "e.employeeName," +
            "w.websiteId," +
            "w.websiteName," +
            "g.groupId," +
            "g.groupName " +
            ") from ChatBoxEntity cb " +
            "join CustomerEntity c on cb.customerId = c.customerId " +
            "join WebsiteEntity w on w.websiteId = cb.websiteId " +
            "join GroupEntity g on g.groupId = w.groupId " +
            "join EmployeeEntity e on g.employeeId = e.employeeId " +
            "where (:websiteName is null or w.websiteName like %:websiteName%) " +
            "and (:websiteOrigin is null or w.websiteOrigin = :websiteOrigin) " +
            "and (:customerId is null or cb.customerId = :customerId)")
    List<ChatBoxEntityDto> filterByWebsiteOriginAndWebsiteNameAndCustomerId(String websiteOrigin, String websiteName, String customerId);
}
