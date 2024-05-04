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
    @Column(name = "website_origin")
    String websiteOrigin;
    @Column(name = "website_key")
    String websiteKey;
    @Column(name = "show_from")
    Long showFrom;
    @Column(name = "group_id")
    String groupId;
}