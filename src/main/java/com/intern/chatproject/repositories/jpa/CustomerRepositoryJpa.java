package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepositoryJpa extends JpaRepository<CustomerEntity, String> {

    boolean existsCustomerEntityByCustomerId(String customerId);
    boolean existsCustomerEntityByCustomerNameAndPhoneNumber(String customerName, String phoneNumber);
    boolean existsCustomerEntityByOauthKeyAndOauthTokenAndSource(String oauthKey, String oauthToken, Short source);
    boolean existsCustomerEntityByOauthKey(String oauthKey);
    @Query("select new com.intern.chatproject.dto.CustomerEntityDto(" +
            "ua.customerId," +
            "ua.customerName," +
            "ua.oauthKey," +
            "ua.oauthToken," +
            "ua.source," +
            "ua.phoneNumber) " +
            "from CustomerEntity ua " +
            "where ua.customerName = :customerName " +
            "and ua.phoneNumber = :phoneNumber")
    Optional<CustomerEntityDto> getCustomerEntityDtoByCustomerNameAndPhoneNumber(String customerName, String phoneNumber);
    Optional<CustomerEntity> getCustomerEntityByCustomerNameAndPhoneNumber(String customerName, String phoneNumber);

    @Query("select new com.intern.chatproject.dto.CustomerEntityDto(" +
            "ua.customerId," +
            "ua.customerName," +
            "ua.oauthKey," +
            "ua.oauthToken," +
            "ua.source," +
            "ua.phoneNumber) " +
            "from CustomerEntity ua " +
            "where ua.oauthToken = :oauthToken " +
            "and ua.oauthKey = :oauthKey " +
            "and ua.source = :source")
    Optional<CustomerEntityDto> getCustomerEntityDtoByOauthKeyAndOauthTokenAndSource(String oauthKey, String oauthToken, Short source);
    Optional<CustomerEntity> getCustomerEntityByOauthKeyAndOauthTokenAndSource(String oauthKey, String oauthToken, Short source);
}
