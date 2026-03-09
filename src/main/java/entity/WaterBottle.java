package com.kavinda.water_delivery.entity;


import jakarta.persistence.*;
import com.kavinda.water_delivery.entity.OrderItem;
import lombok.Data;
import java.util.List;


@Entity
@Table(name = "water_bottles")
@Data
public class WaterBottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., "1L Mineral Water"
    private Double price;
    private String size; // optional
    private String description; // optional

    // Relationship: Many OrderItems can reference the same bottle
    @OneToMany(mappedBy = "waterBottle")
    private List<OrderItem> orderItems;
}
