package com.intern.chatproject.repositories.jpa;

import com.intern.chatproject.dto.EmployeeEntityDto;
import com.intern.chatproject.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepositoryJpa extends JpaRepository<EmployeeEntity, String> {
    boolean existsEmployeeEntityByUsername(String username);
    boolean existsEmployeeEntityByUsernameAndUsernameIsNot(String username, String in);
    boolean existsEmployeeEntityByEmployeeId(String employeeId);
    boolean existsEmployeeEntityByUsernameAndPassword(String username, String password);
    @Query("select new com.intern.chatproject.dto.EmployeeEntityDto(" +
            "e.employeeId," +
            "e.employeeName," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "e.status)" +
            " from EmployeeEntity e" +
            " where e.status = 1 and e.employeeId = :employeeId")
    Optional<EmployeeEntityDto> getEmployeeEntityDtoByEmployeeId(String employeeId);
    Optional<EmployeeEntity> getEmployeeEntityByEmployeeId(String employeeId);

    @Query("select c from EmployeeEntity c where c.employeeId= :employeeId and c.status = 1")
    Optional<EmployeeEntity> getEmployeeEntityByEmployeeActive(String employeeId);

    @Query("select new com.intern.chatproject.dto.EmployeeEntityDto(" +
            "e.employeeId," +
            "e.employeeName," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "e.status)" +
            " from EmployeeEntity e" +
            " where e.status = 1" +
            " and e.username = :username and e.password = :password")
    Optional<EmployeeEntityDto> getEmployeeEntityDtoByUsernameAndPassword(String username, String password);


    @Query("select distinct new com.intern.chatproject.dto.EmployeeEntityDto(" +
            "e.employeeId," +
            "e.employeeName," +
            "e.phoneNumber," +
            "e.username," +
            "e.password," +
            "e.status)" +
            " from EmployeeEntity e " +
            " join EmployeeRoleEntity er on e.employeeId = er.employeeId " +
            " where e.status = 1" +
            " and (:employeeFullname is null or e.employeeName like %:employeeName%)" +
            " and (:employeeId is null or e.employeeId like %:employeeId%)" +
            " and (:roleId is null or er.roleId = :roleId)")
    List<EmployeeEntityDto> getEmployeeEntityDtoByProperties(String employeeId, String employeeName, String roleId);

}

