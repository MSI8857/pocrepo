package com.nokia.customer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.customer.dto.CustomerDto;
import com.nokia.customer.service.ManageCustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerApiController {

	@Autowired
	private ManageCustomerService manageCustomerService;

	@PostMapping(value = "/saveCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
		return manageCustomerService.saveCustomer(customerDto);
	}

	@GetMapping(value = "/fetchAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CustomerDto> getCustomers() {
		return manageCustomerService.getCustomers();
	}

	@GetMapping(value = "/fetchCustomerByCustomerName/{customerName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerDto getCustomerByCustomerName(@PathVariable("customerName") String customerId) {
		return manageCustomerService.getCustomerByCustomerId(customerId);
	}

	@PutMapping(value = "/updateCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {
		return manageCustomerService.updateCustomer(customerDto);
	}

	@DeleteMapping(value = "/deleteCustomer", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteCustomer(@RequestBody CustomerDto customer) {
		return manageCustomerService.deleteCustomer(customer);
	}
}