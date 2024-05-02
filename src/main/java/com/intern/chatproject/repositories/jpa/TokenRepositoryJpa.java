package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TokenRepositoryJpa extends JpaRepository<TokenEntity, String> {
    Optional<TokenEntity> getTokenEntityByEntityId(String entityId);
    Optional<TokenEntity> getTokenEntityByTokenId(String tokenId);
    boolean existsTokenEntityByEntityId(String tokenId);
    boolean existsTokenEntityByTokenId(String tokenId);
}
