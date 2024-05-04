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
@Table(name = "chat_box")
public class ChatBoxEntity {
    @Id
    @Column(name = "chat_box_id")
    String chatBoxId;
    @Column(name = "chat_box_name")
    String chatBoxName;
    @Column(name = "customer_id")
    String customerId;
    @Column(name = "website_id")
    String websiteId;
}
