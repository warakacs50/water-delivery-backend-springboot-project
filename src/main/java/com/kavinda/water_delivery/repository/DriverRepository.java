package com.kavinda.water_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kavinda.water_delivery.entity.Driver;

@Repository
interface DriverRepository extends JpaRepository <Driver , Long>{

}