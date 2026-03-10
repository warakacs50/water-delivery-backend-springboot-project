package com.kavinda.water_delivery.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.kavinda.water_delivery.entity.Delivery;
import java.util.List;

@Entity
@Table(name = "drivers")
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    // Relationship with Delivery
    @OneToMany(mappedBy = "driver")
    private List<Delivery> deliveries;

    // getters and setters
}