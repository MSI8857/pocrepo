package com.nokia.customer.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nokia.customer.dto.CustomerDto;
import com.nokia.customer.entities.Customer;
import com.nokia.customer.repositories.CustomerRepository;

@Service
public class ManageCustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional(readOnly = false)
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customer = customerRepository.save(customer);
		return new CustomerDto(customer.getCustomerId(), customer.getIsAlu(), customer.getCustomerName(),
				customer.getUserId());
	}

	@Transactional(readOnly = true)
	public List<CustomerDto> getCustomers() {
		return customerRepository.findAll().stream().map(customer -> {
			return new CustomerDto(customer.getCustomerId(), customer.getIsAlu(), customer.getCustomerName(),
					customer.getUserId());
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CustomerDto getCustomerByCustomerId(String customerId) {
		return customerRepository.findById(customerId).map(customer -> {
			return new CustomerDto(customer.getCustomerId(), customer.getIsAlu(), customer.getCustomerName(),
					customer.getUserId());
		}).get();
	}

	@Transactional(readOnly = false)
	public CustomerDto updateCustomer(CustomerDto customer) {
		Customer customerEntity = customerRepository.getById(customer.getCustomerId());
		if (customerEntity != null) {
			customerEntity.setCustomerId(customer.getCustomerId());
			customerEntity.setIsAlu(customer.getIsAlu());
			customerEntity.setCustomerName(customer.getCustomerName());
			customerEntity.setUserId(customer.getUserId());
			customerEntity = customerRepository.save(customerEntity);
		}

		return new CustomerDto(customer.getCustomerId(), customer.getIsAlu(), customer.getCustomerName(),
				customer.getUserId());
	}

	@Transactional(readOnly = false)
	public String deleteCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setIsAlu(customerDto.getIsAlu());
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setUserId(customerDto.getUserId());
		String status = null;

		try {
			Customer existingCustomer = customerRepository.findById(customerDto.getCustomerId()).get();
			customerRepository.delete(existingCustomer);
			status = "customer is deleted successfully";
		} catch (NoSuchElementException e) {
			status = "no customer available with the given id";
		}
		return status;
	}

}
