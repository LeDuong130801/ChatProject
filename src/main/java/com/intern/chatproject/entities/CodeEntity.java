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
@Table(name = "code")
public class CodeEntity {
    @Id
    @Column(name = "code_id")
    String codeId;
    @Column(name = "code_content")
    String codeContent;
    @Column(name = "email")
    String email;
    @Column(name = "session")
    String session;
    @Column(name = "valid_time")
    Long validTime;
}
