package com.reward.RewardSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private String customerID;
	private String name;
	
	private String getCustomerID() {
		return customerID;
	}
	private void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
}
