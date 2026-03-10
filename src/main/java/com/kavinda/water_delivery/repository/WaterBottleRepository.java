package com.kavinda.water_delivery.repository;

import com.kavinda.water_delivery.entity.WaterBottle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface WaterBottleRepository extends JpaRepository <WaterBottle , Long > {

}