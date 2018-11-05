package org.carrentalsystem.service.impl;

import org.carrentalsystem.model.dao.CustomerDAO;
import org.carrentalsystem.model.data.Customer;
import org.carrentalsystem.service.CustomerAccountService;

public class CustomerAccountServiceImpl implements CustomerAccountService {

	private CustomerDAO customerDAO;
	
	@Override
	public Customer getCustomer(String loginId) {
		return customerDAO.getCustomer(loginId);
	}

	@Override
	public Integer getCustomerId(String loginId){
		return customerDAO.getCustomerId(loginId);
	}
	
	//setters
	public void setCustomerDAO(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}	
	
}
