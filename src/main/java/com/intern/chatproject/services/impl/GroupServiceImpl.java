package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.GroupEntityDto;
import com.intern.chatproject.entities.GroupEntity;
import com.intern.chatproject.repositories.jpa.GroupRepositoryJpa;
import com.intern.chatproject.repositories.jpa.WebsiteRepositoryJpa;
import com.intern.chatproject.services.GroupService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepositoryJpa groupRepositoryJpa;
    @Autowired
    WebsiteRepositoryJpa websiteRepositoryJpa;

    @Override
    public Object create(GroupEntityDto dto) {
        GroupEntity entity = GroupEntity.builder()
                .groupId(UUID.randomUUID().toString())
                .groupName(dto.getGroupName())
                .allowGuest(dto.getAllowGuest() == null ? Constrants.STATUS.INACTIVE : dto.getAllowGuest())
                .employeeId(dto.getEmployeeId() == null ? Util.employeeSaleId() : dto.getEmployeeId())
                .build();
        return groupRepositoryJpa.save(entity);
    }

    @Override
    public Object getById(String id) {
        return groupRepositoryJpa.getGroupEntityByGroupId(id);
    }
    public Object getAll(){
        List<GroupEntityDto> entityDtoList = groupRepositoryJpa.getAllGroupEntityDto();
        for (GroupEntityDto groupEntityDto: entityDtoList){
            groupEntityDto.setWebsiteEntityDtoList(websiteRepositoryJpa.getWebsiteEntityDtoByGroupId(groupEntityDto.getGroupId()));
        }
        return entityDtoList;
    }
}
