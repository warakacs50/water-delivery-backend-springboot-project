package com.kavinda.water_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kavinda.water_delivery.entity.OrderItem;

@Repository
interface OrderItemRepository extends JpaRepository <OrderItem , Long > {

}