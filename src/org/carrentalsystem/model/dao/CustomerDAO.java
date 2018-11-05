package org.carrentalsystem.model.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.carrentalsystem.model.data.Customer;

public class CustomerDAO {

	Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	//assume loginId is also unique for customers
	Map<String, Customer> customersByLoginId = new HashMap<String, Customer>();
	static int customerId = 0; //identifier generator
	
//	// no database here. so pass the data to DAO during initialization
//	public CustomerDAO(Map<Integer, Customer> customers){
//		Objects.requireNonNull(customers, "customers should not be null");
//		this.customers = customers;
//		this.customersByLoginId = new HashMap<String, Customer>();
//		for(Integer k : this.customers.keySet()){
//			Customer aCustomer = this.customers.get(k);
//			//assume loginId is also unique for customers
//			this.customersByLoginId.put( aCustomer.getCustomerLoginId(), aCustomer);
//		}
//	}
	
	public void addCustomer(Customer newCustomer){
		customerId ++;
		newCustomer.setCustomerId(customerId);
		customers.put(customerId, newCustomer);
		//assume loginId is also unique for customers
		customersByLoginId.put(newCustomer.getCustomerLoginId(), newCustomer);
	}

	public Customer getCustomer(Integer customerId){
		return customers.get(customerId);
	}
	
	public Customer getCustomer(String customerLoginId){
		return customersByLoginId.get(customerLoginId);
	}

	public Integer getCustomerId(String customerLoginId){
		return customersByLoginId.get(customerLoginId).getCustomerId();
	}	
}
