package org.carrentalsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.carrentalsystem.Request.AssignRequest;
import org.carrentalsystem.Request.OrderRequest;
import org.carrentalsystem.model.dao.CarDAO;
import org.carrentalsystem.model.dao.CarRentalDAO;
import org.carrentalsystem.model.dao.CustomerDAO;
import org.carrentalsystem.model.data.Car;
import org.carrentalsystem.model.data.CarRental;
import org.carrentalsystem.model.data.Customer;
import org.carrentalsystem.model.data.RentalStatus;
import org.carrentalsystem.service.CarRentalService;

public class CarRentalServiceImpl implements CarRentalService {
	
	private CarDAO carDAO;
	private CarRentalDAO carRentalDAO;
	private CustomerDAO customerDAO;

	@Override
	// TODO: return a response object which includes status and message.
	public Boolean reserveCar(OrderRequest orderRequest) {
		
		Boolean result = false;
		if(isCarAvailable(orderRequest)){
			createOrder(orderRequest);			
			result = true;
		}

		System.out.println("customerId=" + orderRequest.getCustomerId() + " " + (result?"succeeded":"failed"));
		System.out.printf("%1$s %2$tY-%2$tm-%2$td  %3$tY-%3$tm-%3$td\n", orderRequest.getCarType(), orderRequest.getStartDate(), orderRequest.getEndDate());
		return result;
	}
	
	@Override
	// TODO: return a response object which includes status and message.
	public Boolean assignCar(AssignRequest assignRequest){
		Boolean result = false;
		CarRental carRental = carRentalDAO.getCarRentalByCustomerId(assignRequest.getCustomerId());
		if(carRental!=null){
			carRental.setCarId(assignRequest.getCarId());
			carRental.setRentalStatus(RentalStatus.HoldCar);
			carRentalDAO.updateCarRental(carRental);
			result = true;
		}
		
		return result;
	}
	
	private Boolean isCarAvailable(OrderRequest orderRequest){
		
		Boolean result = false;
		
		List<Car> carsByCarType = carDAO.getCarsByType(orderRequest.getCarType());
		List<CarRental> currentCarRentalsByCarType = carRentalDAO.getCarRentalsByCarType(orderRequest.getCarType());
		// check if the total number of the cars by type are more than the rentals
		if(carsByCarType.size() > currentCarRentalsByCarType.size()){
			result = true;
		}
		// check if in the reserved time period how many overlaps from existing car rentals. 
		// if it is less than the total number of cars by type there is at least one car available.
		else if(carsByCarType.size() > getNumberOfOverlapping(orderRequest.getStartDate(), orderRequest.getEndDate(), currentCarRentalsByCarType)){
			result = true;
		}

		return result;
	}

	private int getNumberOfOverlapping(Date startDate, Date endDate, List<CarRental> currentCarRentalsByCarType){
		int numberOfOverlapping = 0;
		for(CarRental carRental : currentCarRentalsByCarType){
			if(isDateInRange(carRental.getStartDate(), startDate, endDate) || isDateInRange(carRental.getEndDate(), startDate, endDate)){
				numberOfOverlapping ++;
			}
		}		
		
		return numberOfOverlapping;
	}
	
	private boolean isDateInRange(Date date, Date rangeBegin, Date rangeEnd){
		return date.getTime()>=rangeBegin.getTime() && date.getTime()<=rangeEnd.getTime();
	}
	
	private void createOrder(OrderRequest orderRequest){
		Customer customer = customerDAO.getCustomer(orderRequest.getCustomerId());
		CarRental carRental = new CarRental();
		carRental.setCustomerId(customer.getCustomerId());
		carRental.setCarType(orderRequest.getCarType());
		carRental.setStartDate(orderRequest.getStartDate());
		carRental.setEndDate(orderRequest.getEndDate());
		carRental.setRentalStatus(RentalStatus.ReserveCar);
		
		carRentalDAO.addCarRental(carRental);
	}

	// setters
	public void setCarDAO(CarDAO carDAO){
		this.carDAO = carDAO;
	}
	
	public void setCarRentalDAO(CarRentalDAO carRentalDAO){
		this.carRentalDAO = carRentalDAO;
	}
	
	public void setCustomerDAO(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}
	
}
