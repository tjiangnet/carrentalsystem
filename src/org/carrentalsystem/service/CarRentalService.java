package org.carrentalsystem.service;

import org.carrentalsystem.Request.AssignRequest;
import org.carrentalsystem.Request.OrderRequest;

public interface CarRentalService {

	/**
	 * Reserve a car
	 * 
	 * @param orderRequest
	 * @return
	 */
	public Boolean reserveCar(OrderRequest orderRequest);
	
	/**
	 * Assign a car to the car rental 
	 * 
	 * @param assignRequest
	 * @return
	 */
	public Boolean assignCar(AssignRequest assignRequest);

}
