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
@Table(name = "user_account")
public class UserAccountEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "user_account_id")
    String userAccountId;
    @Column(name = "user_account_name")
    String userAccountName;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "source")
    Short source;
    @Column(name = "auth_key")
    String authKey;
    @Column(name = "device_id")
    String deviceId;
    @Column(name = "status")
    Short status;
}
