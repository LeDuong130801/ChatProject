package com.intern.chatproject.services.impl;

import com.intern.chatproject.dto.RoleEntityDto;
import com.intern.chatproject.entities.RoleEntity;
import com.intern.chatproject.repositories.jpa.RoleRepositoryJpa;
import com.intern.chatproject.services.RoleService;
import com.intern.chatproject.utils.Constrants;
import com.intern.chatproject.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepositoryJpa roleRepositoryJpa;

    @Override
    public Object create(RoleEntityDto dto) {
        Long currentTime = System.currentTimeMillis();
        if (dto.getRoleId()==null){
            dto.setRoleId(UUID.randomUUID().toString());
        }
        RoleEntity entity = RoleEntity.builder()
                .roleId(dto.getRoleId())
                .roleName(dto.getRoleName())
                .status(Constrants.STATUS.ACTIVE)
                .createBy(Util.auth())
                .createTime(currentTime)
                .updateBy(Util.auth())
                .updateTime(currentTime)
                .build();
        return roleRepositoryJpa.save(entity);
    }

    @Override
    public Object edit(RoleEntityDto dto) {
        return null;
    }

    @Override
    public List<String> delete(List<String> roleIdList) {
        return null;
    }

    public Object getById(String roleId){
        return roleRepositoryJpa.getRoleEntityDtoByRoleId(roleId);
    }
}
