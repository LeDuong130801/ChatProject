package com.intern.chatproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "group_web")
public class GroupEntity {
    @Id
    @Column(name = "group_id")
    String groupId;
    @Column(name = "group_name")
    String groupName;
    @Column(name = "allow_guest")
    Short allowGuest;
    @Column(name = "employee_id")
    String employeeId;
}
