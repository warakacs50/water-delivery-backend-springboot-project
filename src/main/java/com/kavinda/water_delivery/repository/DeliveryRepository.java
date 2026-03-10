package com.kavinda.water_delivery.repository;

import com.kavinda.water_delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DeliveryRepository extends JpaRepository <Delivery , Long> {

}