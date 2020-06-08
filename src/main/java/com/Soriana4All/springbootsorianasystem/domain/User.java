package com.Soriana4All.springbootsorianasystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	private String customerName;
	private int customerAge;
	private String customerNumber;
	private String customerEmail;
	
	public User() {
	
	}
	
	public User(Integer customerId, String customerName, int customerAge, String customerNumber, String customerEmail) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerNumber = customerNumber;
		this.customerEmail = customerEmail;
		
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return getCustomerName() + " - " + getCustomerNumber() + " - " + getCustomerEmail();
	}
	
	
	
}
