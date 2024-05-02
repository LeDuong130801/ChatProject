package com.intern.chatproject.repositories.jpa;


import com.intern.chatproject.dto.RoleEntityDto;
import com.intern.chatproject.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepositoryJpa extends JpaRepository<RoleEntity, String> {
    boolean existsRoleEntityByRoleName(String roleName);
    boolean existsRoleEntityByRoleId(String roleId);

    @Query("select new com.intern.chatproject.dto.RoleEntityDto(" +
            "r.roleId," +
            "r.roleName," +
            "r.status," +
            "r.createBy," +
            "r.createTime," +
            "r.updateBy," +
            "r.updateTime) " +
            "from RoleEntity r where r.status = 1 and r.roleId = :roleId")
    Optional<RoleEntityDto> getRoleEntityDtoByRoleId(String roleId);

    @Query("select new com.intern.chatproject.dto.RoleEntityDto(" +
            "r.roleId," +
            "r.roleName," +
            "r.status," +
            "r.createBy," +
            "r.createTime," +
            "r.updateBy," +
            "r.updateTime) " +
            "from RoleEntity r where r.status = 1 and r.roleName like %:roleName%")
    List<RoleEntityDto> getRoleEntityDtoByRoleName(String roleName);
}