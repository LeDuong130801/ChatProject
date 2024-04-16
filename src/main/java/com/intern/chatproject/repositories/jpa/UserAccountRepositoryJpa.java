package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.UserAccountDto;
import com.intern.chatproject.entities.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepositoryJpa extends JpaRepository<UserAccountEntity, String> {

    boolean existsUserAccountEntityByUserAccountId(String userAccountId);
    boolean existsUserAccountEntityByEmail(String email);
    boolean existsUserAccountEntityByEmailAndPassword(String username, String password);
    boolean existsUserAccountEntityByAuthKeyAndSource(String authKey, Short source);
    boolean existsUserAccountEntityByDeviceId(String deviceId);

    @Query("select new com.intern.chatproject.dto.UserAccountDto(" +
            "ua.userAccountId," +
            "ua.userAccountName," +
            "ua.email," +
            "ua.password," +
            "ua.authKey," +
            "ua.source," +
            "ua.deviceId," +
            "ua.status) " +
            "from UserAccountEntity ua " +
            "where ua.email = :email " +
            "and ua.password = :password")
    Optional<UserAccountDto> getUserAccountEntityDtoByUsernameAndPassword(String email, String password);

    Optional<UserAccountEntity> getUserAccountEntityByEmailAndPassword(String email, String password);

    @Query("select new com.intern.chatproject.dto.UserAccountDto(" +
            "ua.userAccountId," +
            "ua.userAccountName," +
            "ua.email," +
            "ua.password," +
            "ua.authKey," +
            "ua.source," +
            "ua.deviceId," +
            "ua.status) " +
            "from UserAccountEntity ua " +
            "where ua.deviceId = :deviceId ")
    Optional<UserAccountDto> getUserAccountEntityDtoByDeviceId(String deviceId);
}
