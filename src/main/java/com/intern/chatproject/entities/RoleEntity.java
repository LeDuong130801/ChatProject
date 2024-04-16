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
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(name = "role_id")
    String roleId;
    @Column(name = "role_name")
    String roleName;
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
