package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.EmployeeRoleEntityDto;
import com.intern.chatproject.entities.TokenEntity;
import com.intern.chatproject.repositories.jpa.EmployeeRoleRepositoryJpa;
import com.intern.chatproject.repositories.jpa.TokenRepositoryJpa;
import com.intern.chatproject.utils.Constrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TokenServiceImpl {
    @Autowired
    TokenRepositoryJpa tokenRepositoryJpa;
    @Autowired
    EmployeeRoleRepositoryJpa employeeRoleRepositoryJpa;

    public Short checkToken(String tokenId, String[] roleAccept){
        Optional<TokenEntity> tokenEntityOptional = tokenRepositoryJpa.getTokenEntityByTokenId(tokenId);
        if (tokenEntityOptional.isPresent()){
            TokenEntity tokenEntity = tokenEntityOptional.get();
            if (tokenEntity.isValidTime()){
                for (String role: roleAccept){
                    if (role.equals(tokenEntity.getRole())){
                        return Constrants.TOKEN.tokenAccept;
                    }
                }
                return Constrants.TOKEN.tokenNotAccept;
            }
            return Constrants.TOKEN.tokenExpired;
        }
        return Constrants.TOKEN.tokenInvalid;
    }
    public String createToken(String entityId, Short type){
        TokenEntity tokenEntity = new TokenEntity();
        String tokenId = generatorToken();
        StringBuilder role = new StringBuilder();
        while (tokenRepositoryJpa.existsTokenEntityByTokenId(tokenId)){
            tokenId = generatorToken();
        }
        if (type.equals(Constrants.TYPEACCOUNT.CUSTOMER)){
            role = new StringBuilder("CUSTOMER");
        }
        if (type.equals(Constrants.TYPEACCOUNT.EMPLOYEE)){
            List<EmployeeRoleEntityDto> employeeRole = employeeRoleRepositoryJpa.getEmployeeRoleEntityDtoByEmployeeId(entityId);
            for (EmployeeRoleEntityDto entityDto : employeeRole){
                role.append(entityDto.getRoleId());
            }
        }
        tokenEntity = TokenEntity.builder()
                .tokenId(tokenId)
                .entityId(entityId)
                .role(role.toString())
                .validTime(System.currentTimeMillis()+Constrants.basicTokenValid)
                .build();
        return tokenRepositoryJpa.save(tokenEntity).getTokenId();
    }
    private String generatorToken(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 192;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
