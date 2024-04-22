package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.GroupEntityDto;
import com.intern.chatproject.entities.GroupEntity;
import com.intern.chatproject.repositories.jpa.GroupRepositoryJpa;
import com.intern.chatproject.services.GroupService;
import com.intern.chatproject.utils.Constrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepositoryJpa groupRepositoryJpa;

    @Override
    public Object create(GroupEntityDto dto) {
        GroupEntity entity = GroupEntity.builder()
                .groupId(UUID.randomUUID().toString())
                .groupName(dto.getGroupName())
                .allowGuest(dto.getAllowGuest() == null ? Constrants.STATUS.ACTIVE : Constrants.STATUS.INACTIVE)
                .build();
        return groupRepositoryJpa.save(entity);
    }

    @Override
    public Object getById(String id) {
        return groupRepositoryJpa.getGroupEntityByGroupId(id);
    }
}
