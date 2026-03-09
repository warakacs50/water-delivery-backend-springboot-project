package com.kavinda.water_delivery.entity;


import jakarta.persistence.*;
import com.kavinda.water_delivery.entity.Order;
import com.kavinda.water_delivery.entity.WaterBottle;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    // Many items belong to one order
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Many items can reference one water bottle
    @ManyToOne
    @JoinColumn(name = "water_bottle_id")
    private WaterBottle waterBottle;
}
