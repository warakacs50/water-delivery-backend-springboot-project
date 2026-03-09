package com.kavinda.water_delivery.entity;


import jakarta.persistence.*;
import lombok.Data;
import com.kavinda.water_delivery.entity.Order;
import com.kavinda.water_delivery.entity.Driver;
import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime deliveryTime;
    private String status; // e.g., "PENDING", "DELIVERED"

    // One delivery for one order
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Many deliveries can be done by one driver
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
