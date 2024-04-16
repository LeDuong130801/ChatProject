package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.EmployeeRoleEntityDto;
import com.intern.chatproject.dto.RoleEntityDto;
import com.intern.chatproject.entities.EmployeeRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRoleRepositoryJpa extends JpaRepository<EmployeeRoleEntity, String> {
    boolean existsEmployeeRoleEntityByEmployeeIdAndRoleId(String employeeId, String roleId);

    @Query("select new com.intern.chatproject.dto.EmployeeRoleEntityDto(" +
            "er.employeeRoleId," +
            "er.employeeId," +
            "er.roleId," +
            "e.employeeFullname," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "r.roleName" +
            ") from EmployeeRoleEntity er " +
            "join EmployeeEntity e on er.employeeId = e.employeeId " +
            "join RoleEntity r on er.roleId = r.roleId")
    List<EmployeeRoleEntityDto> getAllEmployeeRoleEntityDto();

    @Query("select new com.intern.chatproject.dto.EmployeeRoleEntityDto(" +
            "er.employeeRoleId," +
            "er.employeeId," +
            "er.roleId," +
            "e.employeeFullname," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "r.roleName" +
            ") from EmployeeRoleEntity er " +
            "join EmployeeEntity e on er.employeeId = e.employeeId " +
            "join RoleEntity r on er.roleId = r.roleId " +
            "where er.employeeRoleId = : employeeRoleId " +
            "and e.status = 1 " +
            "and r.status = 1")
    Optional<EmployeeRoleEntityDto> getEmployeeRoleEntityDtoByEmployeeRoleId(String employeeRoleId);

    @Query("select new com.intern.chatproject.dto.EmployeeRoleEntityDto(" +
            "er.employeeRoleId," +
            "er.employeeId," +
            "er.roleId," +
            "e.employeeFullname," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "r.roleName" +
            ") from EmployeeRoleEntity er " +
            "join EmployeeEntity e on er.employeeId = e.employeeId " +
            "join RoleEntity r on er.roleId = r.roleId " +
            "where er.employeeId = :employeeId " +
            "and e.status = 1 " +
            "and r.status = 1")
    List<EmployeeRoleEntityDto> getEmployeeRoleEntityDtoByEmployeeId(String employeeId);

    @Query("select new com.intern.chatproject.dto.EmployeeRoleEntityDto(" +
            "er.employeeRoleId," +
            "er.employeeId," +
            "er.roleId," +
            "e.employeeFullname," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "r.roleName" +
            ") from EmployeeRoleEntity er " +
            "join EmployeeEntity e on er.employeeId = e.employeeId " +
            "join RoleEntity r on er.roleId = r.roleId " +
            "where er.roleId = :roleId " +
            "and e.status = 1 " +
            "and r.status = 1")
    List<EmployeeRoleEntityDto> getEmployeeRoleEntityDtoByRoleId(String roleId);

    @Query("select new com.intern.chatproject.dto.RoleEntityDto(" +
            "r.roleId," +
            "r.roleName," +
            "r.status," +
            "r.createBy," +
            "r.createTime," +
            "r.updateBy," +
            "r.updateTime) " +
            "from RoleEntity r " +
            "join EmployeeRoleEntity er on er.roleId = r.roleId " +
            "where r.status = 1 and er.employeeId = :employeeId")
    List<RoleEntityDto> getRoleEntityDtoOfEmployeeId(String employeeId);

}
