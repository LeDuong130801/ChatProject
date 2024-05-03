package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.CustomerEntityDto;
import com.intern.chatproject.entities.ChatBoxEntity;
import com.intern.chatproject.entities.CustomerEntity;
import com.intern.chatproject.entities.GoogleUserInfo;
import com.intern.chatproject.repositories.jpa.ChatBoxRepositoryJpa;
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

    @Override
    public Object create(CustomerEntityDto dto, TokenServiceImpl tokenService) {
        String customerId = UUID.randomUUID().toString();
        CustomerEntity entity;
        while (customerRepositoryJpa.existsCustomerEntityByCustomerId(customerId)) {
            customerId = UUID.randomUUID().toString();
        }
        if (dto.getSource() == null){
            dto.setSource(Constrants.SOURCE.NO_SOURCE);
        }
        if (dto.getSource().equals(Constrants.SOURCE.NO_SOURCE)){
            if (customerRepositoryJpa.existsCustomerEntityByPhoneNumber(dto.getPhoneNumber())){
                return CustomException.error(-1, Constrants.MESSAGE_ERROR.phoneNumberHasUsed);
            }
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
            if (customerRepositoryJpa.existsCustomerEntityByOauthKey(dto.getOauthKey())){
                return CustomException.error(-1, Constrants.MESSAGE_ERROR.emailHasUsed);
            }
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
        customerRepositoryJpa.save(entity);
        String token = tokenService.createToken(customerId, Constrants.TYPEACCOUNT.CUSTOMER);
        ChatBoxEntity chatBoxEntity = ChatBoxEntity.builder()
                .chatBoxId(UUID.randomUUID().toString())
                .chatBoxName(dto.getCustomerName())
                .customerId(customerId)
                .employeeId(Util.employeeSaleId())
                .websiteId(Util.websiteId())
                .build();
        chatBoxRepositoryJpa.save(chatBoxEntity);
        Optional<CustomerEntityDto> customerEntityDto = customerRepositoryJpa.getCustomerEntityDtoByCustomerAndIdSource(entity.getCustomerId(), entity.getSource());
        CustomerEntityDto customerEntityDto1 = customerEntityDto.get();
        customerEntityDto1.setToken(token);
        return customerEntityDto1;
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
    public Object login(CustomerEntityDto dto, TokenServiceImpl tokenService) {
        if (dto.getSource() == null){
            dto.setSource(Constrants.SOURCE.NO_SOURCE);
        }
        if (dto.getSource().equals(Constrants.SOURCE.NO_SOURCE)){
            Optional<CustomerEntityDto> entity = customerRepositoryJpa.getCustomerEntityDtoByCustomerNameAndPhoneNumber(dto.getCustomerName(), dto.getPhoneNumber());
            if (entity.isPresent()){
                CustomerEntityDto customerEntityDto = entity.get();
                customerEntityDto.setToken(tokenService.createToken(customerEntityDto.getCustomerId(), Constrants.TYPEACCOUNT.CUSTOMER));
                return customerEntityDto;
            }
            else if (!customerRepositoryJpa.existsCustomerEntityByPhoneNumber(dto.getPhoneNumber())){
                return create(dto, tokenService);
            }
        }
        else
        {
            Optional<CustomerEntityDto> customerEntityDtoOptional =  customerRepositoryJpa.getCustomerEntityDtoByOauthKeyAndOauthTokenAndSource(
                dto.getOauthKey(),
                dto.getOauthToken(),
                Constrants.SOURCE.EMAIL);
            if (customerEntityDtoOptional.isPresent()){
                CustomerEntityDto customerEntityDto = customerEntityDtoOptional.get();
                customerEntityDto.setToken(tokenService.createToken(customerEntityDto.getCustomerId(), Constrants.TYPEACCOUNT.CUSTOMER));
                return customerEntityDto;
            }
        }
        return CustomException.error(-1, Constrants.MESSAGE_ERROR.phoneNumberHasUsed);
    }
    @Override
    public Object login(GoogleUserInfo googleUserInfo, TokenServiceImpl tokenService) {
        Optional<CustomerEntityDto> customerEntityDtoOptional =  customerRepositoryJpa.getCustomerEntityDtoByOauthKeyAndOauthTokenAndSource(
                    googleUserInfo.getEmail(),
                    googleUserInfo.getUserId(),
                    Constrants.SOURCE.EMAIL);
        if (customerEntityDtoOptional.isPresent()){
            CustomerEntityDto customerEntityDto = customerEntityDtoOptional.get();
            customerEntityDto.setToken(tokenService.createToken(customerEntityDto.getCustomerId(), Constrants.TYPEACCOUNT.CUSTOMER));
            return customerEntityDto;
        }
        CustomerEntityDto dto = CustomerEntityDto.builder()
                .source(Constrants.SOURCE.EMAIL)
                .customerName(googleUserInfo.getName())
                .oauthKey(googleUserInfo.getEmail())
                .oauthToken(googleUserInfo.getUserId())
                .build();
        return create(dto, tokenService);
    }

    @Override
    public Object forgotPassword(CustomerEntityDto dto) {
        return ResponseEntity.ok("No code");
    }
}
