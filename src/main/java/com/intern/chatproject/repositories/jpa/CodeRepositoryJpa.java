package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.entities.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepositoryJpa extends JpaRepository<CodeEntity, String> {
    boolean existsCodeByCodeContentAndSession(String codeContent, String session);
    Optional<CodeEntity> getCodeByCodeContentAndSession(String codeContent, String session);
    void deleteCodeEntityByCodeId(String codeId);
}
