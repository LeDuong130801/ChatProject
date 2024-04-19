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
@Table(name = "website")
public class WebsiteEntity{
    @Id
    @Column(name = "website_id")
    String websiteId;
    @Column(name = "website_name")
    String websiteName;
    @Column(name = "chat_box_id")
    String chatBoxId;
}