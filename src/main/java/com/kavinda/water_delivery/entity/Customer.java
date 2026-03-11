package com.kavinda.water_delivery.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.List;
import com.kavinda.water_delivery.entity.Delivery;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Data
public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Relationship with Order
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;






}