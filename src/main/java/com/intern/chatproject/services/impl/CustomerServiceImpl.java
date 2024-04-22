package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.ChatBoxEntity;
import com.intern.chatproject.entities.CustomerEntity;
import com.intern.chatproject.repositories.jpa.ChatBoxRepositoryJpa;
import com.intern.chatproject.repositories.jpa.CodeRepositoryJpa;
import com.intern.chatproject.repositories.jpa.CustomerRepositoryJpa;
import com.intern.chatproject.services.CustomerService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.Util;
import com.intern.chatproject.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepositoryJpa customerRepositoryJpa;

    @Autowired
    ChatBoxRepositoryJpa chatBoxRepositoryJpa;

    @Autowired
    CodeRepositoryJpa codeRepositoryJpa;

    @Override
    public Object create(CustomerEntityDto dto) {
        String customerId = UUID.randomUUID().toString();
        CustomerEntity entity;
        while (customerRepositoryJpa.existsCustomerEntityByCustomerId(customerId)) {
            customerId = UUID.randomUUID().toString();
        }
        if (dto.getSource() == null){
            dto.setSource(Constrants.SOURCE.NO_SOURCE);
        }
        if (dto.getSource().equals(Constrants.SOURCE.NO_SOURCE)){
            entity = CustomerEntity.builder()
                    .customerId(customerId)
                    .customerName(dto.getCustomerName() == null? "Guest "+customerId : dto.getCustomerName())
                    .phoneNumber(dto.getPhoneNumber())
                    .isOnline(Constrants.STATUS.OFFLINE)
                    .source(dto.getSource())
                    .oauthToken("no")
                    .oauthKey("no")
                    .build();
        }
        else{
            entity = CustomerEntity.builder()
                    .customerId(customerId)
                    .customerName(dto.getCustomerName())
                    .phoneNumber("no")
                    .isOnline(Constrants.STATUS.OFFLINE)
                    .source(dto.getSource())
                    .oauthToken(dto.getOauthToken())
                    .oauthKey(dto.getOauthKey())
                    .build();
        }
        CustomerEntity customerEntity = customerRepositoryJpa.save(entity);
        ChatBoxEntity chatBoxEntity = ChatBoxEntity.builder()
                .chatBoxId(UUID.randomUUID().toString())
                .chatBoxName(dto.getCustomerName())
                .customerId(customerId)
                .employeeId(Util.employeeSaleId())
                .websiteId(Util.websiteId())
                .build();
        chatBoxRepositoryJpa.save(chatBoxEntity);
        return customerEntity;
    }

    @Override
    public Object edit(CustomerEntityDto dto) {
//        if (customerRepositoryJpa.existsCustomerEntityByCustomerId(dto.getCustomerId())){
//            CustomerEntity entity = CustomerEntity.builder()
//                    .customerId(dto.getCustomerId())
//                    .customerName(dto.getCustomerName())
//                    .
//                    .source(dto.getSource())
//                    .status(Constrants.STATUS.ACTIVE)
//                    .build();
//            return customerRepositoryJpa.save(entity);
//        }
        throw new CustomException("No code");
    }

    @Override
    public Object changePassword(CustomerEntityDto dto) {
//        if (customerRepositoryJpa.existsCustomerEntityByEmailAndPassword(dto.getEmail(), dto.getPassword())){
//            Optional<CustomerEntity> optionalEntity = customerRepositoryJpa.getCustomerEntityByEmailAndPassword(dto.getEmail(), dto.getPassword());
//            if (optionalEntity.isPresent()){
//                CustomerEntity entity = optionalEntity.get();
//                entity.setPassword(dto.getNewPassword());
//                return customerRepositoryJpa.save(entity);
//            }
//        }
        throw new CustomException("No code");
    }

    @Override
    public Object login(CustomerEntityDto dto) {
        if (dto.getSource().equals(Constrants.SOURCE.NO_SOURCE)){
            Optional<?> entity = customerRepositoryJpa.getCustomerEntityByCustomerNameAndPhoneNumber(dto.getCustomerName(), dto.getPhoneNumber());
            if (entity.isPresent()) return entity.get();
        }
        else
        {
            Optional<?> entity = customerRepositoryJpa.getCustomerEntityByOauthKeyAndOauthTokenAndSource(dto.getOauthKey(), dto.getOauthToken(), dto.getSource());
            if (entity.isPresent()) return entity.get();
        }
        return ResponseEntity.ok("Wrong! please input again");
    }

    @Override
    public Object forgotPassword(CustomerEntityDto dto) {
        return ResponseEntity.ok("No code");
    }
}
