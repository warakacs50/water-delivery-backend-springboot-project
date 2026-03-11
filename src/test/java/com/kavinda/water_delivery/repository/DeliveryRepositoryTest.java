package com.kavinda.water_delivery.repository;

import com.kavinda.water_delivery.entity.Customer;
import com.kavinda.water_delivery.entity.Delivery;
import com.kavinda.water_delivery.entity.Driver;
import com.kavinda.water_delivery.entity.Order;
import com.kavinda.water_delivery.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void testSaveDeliveryWithOrderAndDriver() {
        // 1. Create a Customer
        Customer customer = new Customer();
        customer.setName("Alice");
        customer.setEmail("alice@example.com");
        customer.setAddress("Wonderland 123");
        customer.setPhoneNumber("111222333");
        customerRepository.save(customer);

        // 2. Create an Order for that Customer
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderTime(LocalDateTime.now());



        // Save order (cascades will save OrderItem)
        orderRepository.save(order);

        // 3. Create a Driver
        Driver driver = new Driver();
        driver.setName("Bob the Driver");
        driver.setPhoneNumber("999888777");
        driverRepository.save(driver);

        // 4. Create Delivery linked to Order and Driver
        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDriver(driver);
        delivery.setDeliveryTime(LocalDateTime.now().plusHours(1));
        delivery.setStatus("PENDING");

        Delivery savedDelivery = deliveryRepository.save(delivery);

        // Assertions
        assertThat(savedDelivery.getId()).isNotNull();
        assertThat(savedDelivery.getOrder()).isEqualTo(order);
        assertThat(savedDelivery.getDriver()).isEqualTo(driver);
        assertThat(savedDelivery.getStatus()).isEqualTo("PENDING");
    }
}