package com.kavinda.water_delivery.repository;

import com.kavinda.water_delivery.entity.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Save Customer Test")
    void testSaveCustomer(){

        Customer customer = new Customer();

        customer.setName("Kavinda");
        customer.setEmail("kavinda@test.com");
        customer.setAddress("Jaffna");
        customer.setPhoneNumber("0771234567");

        Customer savedCustomer = customerRepository.save(customer);

        assertNotNull(savedCustomer.getId());
        assertEquals("Kavinda", savedCustomer.getName());

    }

    @Test
    @DisplayName("find customer by id test")
    void testFindCustomerById() {

        Customer customer = new Customer();
        customer.setName("Kavinda");
        customer.setEmail("kavinda@test.com");
        customer.setAddress("Jaffna");
        customer.setPhoneNumber("0771234567");

        Customer savedCustomer = customerRepository.save(customer);

        Optional<Customer> foundCustomer =
                customerRepository.findById(savedCustomer.getId());

        assertTrue(foundCustomer.isPresent());
        assertEquals("Kavinda", foundCustomer.get().getName());
    }

    @Test
    @DisplayName("Find All Customers Test")
    void testFindAllCustomers() {

        Customer customer1 = new Customer();
        customer1.setName("Kavinda");
        customer1.setEmail("kavinda@test.com");
        customer1.setAddress("Jaffna");
        customer1.setPhoneNumber("0771234567");

        Customer customer2 = new Customer();

        customer2.setName("Kavinda");
        customer2.setEmail("kavinda@test.com");
        customer2.setAddress("Jaffna");
        customer2.setPhoneNumber("0771234567");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        List<Customer> customers = customerRepository.findAll();

        assertTrue(customers.size() >= 2);
    }

    @Test
    @DisplayName("Delete Customer Test")
    void testDeleteCustomer() {

        Customer customer = new Customer();
        customer.setName("Kavinda");
        customer.setEmail("kavinda@test.com");
        customer.setAddress("Jaffna");
        customer.setPhoneNumber("0771234567");

        Customer savedCustomer = customerRepository.save(customer);

        customerRepository.delete(savedCustomer);

        Optional<Customer> deletedCustomer =
                customerRepository.findById(savedCustomer.getId());

        assertFalse(deletedCustomer.isPresent());
    }
}