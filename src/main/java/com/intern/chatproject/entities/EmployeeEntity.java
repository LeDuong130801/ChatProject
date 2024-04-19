package com.intern.chatproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "employee_id")
    String employeeId;
    @Column(name = "employee_name")
    String employeeName;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;
    @Column(name = "status")
    Short status;
    @Column(name = "create_by")
    String createBy;
    @Column(name = "create_time")
    Long createTime;
    @Column(name = "update_by")
    String updateBy;
    @Column(name = "update_time")
    Long updateTime;
}