package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.UserAccountDto;
import com.intern.chatproject.entities.UserAccountEntity;
import com.intern.chatproject.repositories.jpa.UserAccountRepositoryJpa;
import com.intern.chatproject.services.UserAccountService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepositoryJpa userAccountRepositoryJpa;

    @Override
    public Object create(UserAccountDto dto) {
        if (userAccountRepositoryJpa.existsUserAccountEntityByEmail(dto.getEmail())){
            throw new CustomException("Username or email has exist");
        }
        String userAccountId = UUID.randomUUID().toString();
        while (userAccountRepositoryJpa.existsUserAccountEntityByUserAccountId(userAccountId)) {
            userAccountId = UUID.randomUUID().toString();
        }
        UserAccountEntity entity = UserAccountEntity.builder()
                .userAccountId(userAccountId)
                .userAccountName(dto.getUserAccountName())
                .password(dto.getPassword())
                .deviceId(dto.getDeviceId())
                .email(dto.getEmail())
                .authKey(dto.getAuthKey())
                .source(dto.getSource())
                .status(Constrants.STATUS.ACTIVE)
                .build();
        return userAccountRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(UserAccountDto dto) {
        if (userAccountRepositoryJpa.existsUserAccountEntityByUserAccountId(dto.getUserAccountId())){
            UserAccountEntity entity = UserAccountEntity.builder()
                    .userAccountId(dto.getUserAccountId())
                    .userAccountName(dto.getUserAccountName())
                    .password(dto.getPassword())
                    .deviceId(dto.getDeviceId())
                    .email(dto.getEmail())
                    .authKey(dto.getAuthKey())
                    .source(dto.getSource())
                    .status(Constrants.STATUS.ACTIVE)
                    .build();
            return userAccountRepositoryJpa.save(entity);
        }
        throw new CustomException("Username or email has exist");
    }

    @Override
    public Object changePassword(UserAccountDto dto) {
        if (userAccountRepositoryJpa.existsUserAccountEntityByEmailAndPassword(dto.getEmail(), dto.getPassword())){
            Optional<UserAccountEntity> optionalEntity = userAccountRepositoryJpa.getUserAccountEntityByEmailAndPassword(dto.getEmail(), dto.getPassword());
            if (optionalEntity.isPresent()){
                UserAccountEntity entity = optionalEntity.get();
                entity.setPassword(dto.getNewPassword());
                return userAccountRepositoryJpa.save(entity);
            }
        }
        throw new CustomException("Username or password incorrect");
    }
}
