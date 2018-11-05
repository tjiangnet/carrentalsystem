package org.carrentalsystem.service;

import org.carrentalsystem.model.data.Customer;

public interface CustomerAccountService {
	
	/**
	 * get Customer by given loginId
	 * 
	 * @param loginId
	 * @return
	 */
	public Customer getCustomer(String loginId);
	
	/**
	 * get customerId by given loginId
	 * 
	 * @param loginId
	 * @return
	 */
	public Integer getCustomerId(String loginId);
	
}
