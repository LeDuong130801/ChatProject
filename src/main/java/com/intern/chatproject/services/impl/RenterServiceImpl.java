package com.intern.chatproject.services.impl;

//import com.intern.chatproject.dto.RenterEntityDto;
//import com.intern.chatproject.entities.RenterEntity;
//import com.intern.chatproject.repositories.jpa.RenterRepositoryJpa;
//import com.intern.chatproject.services.RenterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

//import java.util.UUID;
//
//@Service
//public class RenterServiceImpl implements RenterService {
//
//    @Autowired
//    RenterRepositoryJpa renterRepositoryJpa;
//
//    @Override
//    public Object create(RenterEntityDto dto) {
//        RenterEntity entity = RenterEntity.builder()
//                .renterId(UUID.randomUUID().toString())
//                .renterName(dto.getRenterName())
//                .build();
//        return renterRepositoryJpa.save(entity);
//    }
//
//    @Override
//    public Object getById(String id) {
//        return renterRepositoryJpa.getRenterEntityDtoByRenterId(id);
//    }
//
//}
