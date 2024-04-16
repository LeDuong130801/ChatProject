package com.intern.chatproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "employee_role")
public class EmployeeRoleEntity {
    @Id
    @Column(name = "employee_role_id")
    String employeeRoleId;
    @Column(name = "employee_id")
    String employeeId;
    @Column(name = "role_id")
    String roleId;
}
