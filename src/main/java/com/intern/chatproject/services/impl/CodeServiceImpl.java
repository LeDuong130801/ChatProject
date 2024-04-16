package com.intern.chatproject.services.impl;

import com.intern.chatproject.entities.CodeEntity;
import com.intern.chatproject.repositories.jpa.CodeRepositoryJpa;
import com.intern.chatproject.utils.Constrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class CodeServiceImpl {
    @Autowired
    CodeRepositoryJpa codeRepositoryJpa;

    public boolean checkCode(CodeEntity codeEntity){
        Optional<CodeEntity> entityOptional = codeRepositoryJpa.getCodeByCodeContentAndSession(codeEntity.getCodeContent(), codeEntity.getSession());
        if (entityOptional.isPresent()){
            CodeEntity entity = entityOptional.get();
            Long currentTime = System.currentTimeMillis();
            if (entity.getValidTime()>currentTime){
                entity.setValidTime(currentTime);
                codeRepositoryJpa.deleteCodeEntityByCodeId(entity.getCodeId());
                return true;
            }
        }
        return false;
    }

    public CodeEntity generatorCode(String email){
        Long currentTime = System.currentTimeMillis();
        CodeEntity codeEntity = CodeEntity.builder()
                .email(email)
                .codeId(UUID.randomUUID().toString())
                .codeContent(generatorRandom())
                .session(generatorRandom())
                .validTime(currentTime+ Constrants.validSession)
                .build();
        return codeRepositoryJpa.save(codeEntity);
    }

    private String generatorRandom(){

        int leftLimit = 97;
        int rightLimit = 122;
        int ul = 'A';
        int ur = 'Z';
        int targetStringLength = 128;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        int randomLimitedInt = 0;
        for (int i = 0; i < targetStringLength; i++) {
            int r = random.nextInt()%3;
            if (r==0){
                randomLimitedInt = ul + (int)
                        (random.nextFloat() * (ur - ul + 1));
            }
            else if (r==1){
                randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
            }
            else if (r==2){
                randomLimitedInt = 48 + (int)
                        (random.nextFloat() * (9));
            }
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
