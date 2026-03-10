package com.kavinda.water_delivery.repository;

import com.kavinda.water_delivery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository extends JpaRepository <Customer,Long>{

}