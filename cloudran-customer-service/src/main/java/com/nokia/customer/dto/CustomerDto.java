package com.nokia.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

	private String customerId;
	private int isAlu;
	private String customerName;
	private String userId;

	

}
