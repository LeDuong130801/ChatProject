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
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "customer_id")
    String customerId;
    @Column(name = "customer_name")
    String customerName;
    @Column(name = "oauth_key")
    String oauthKey;
    @Column(name = "oauth_token")
    String oauthToken;
    @Column(name = "source")
    Short source;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "is_online")
    Short isOnline;
}
