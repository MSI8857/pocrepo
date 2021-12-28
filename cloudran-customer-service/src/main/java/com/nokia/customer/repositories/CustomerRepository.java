package com.nokia.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nokia.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
