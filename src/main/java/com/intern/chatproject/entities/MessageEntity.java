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
@Table(name = "message")
public class MessageEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "message_id")
    String messageId;
    @Column(name = "message_content")
    String messageContent;
    @Column(name = "message_type")
    Short messageType;
    @Column(name = "send_time")
    Long sendTime;
    @Column(name = "chat_box_id")
    String chatBoxId;
    @Column(name = "status")
    Short status;
}
