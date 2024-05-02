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
@Table(name = "token")
public class TokenEntity {
    @Id
    @Column(name = "token_id")
    String tokenId;
    @Column(name = "entity_id")
    String entityId;
    @Column(name = "role_id")
    String role;
    @Column(name = "valid_time")
    Long validTime;
    public Boolean isValidTime(){
        return System.currentTimeMillis() < validTime;
    }
}
