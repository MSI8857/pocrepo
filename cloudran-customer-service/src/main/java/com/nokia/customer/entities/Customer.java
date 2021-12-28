package com.nokia.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "is_alu")
	private int isAlu;
	@Column(name = "customer_nm")
	private String customerName;
	@Column(name = "user_id")
	private String userId;

}
