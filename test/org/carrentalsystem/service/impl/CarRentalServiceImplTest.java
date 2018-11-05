package org.carrentalsystem.service.impl;

import java.text.SimpleDateFormat;

import org.carrentalsystem.Request.OrderRequest;
import org.carrentalsystem.model.dao.CarDAO;
import org.carrentalsystem.model.dao.CarRentalDAO;
import org.carrentalsystem.model.dao.CustomerDAO;
import org.carrentalsystem.model.data.Car;
import org.carrentalsystem.model.data.CarType;
import org.carrentalsystem.model.data.Customer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CarRentalServiceImplTest {

	CustomerAccountServiceImpl customerAccountService;
	CarRentalServiceImpl carRentalService;
	
    @Before
    public void setup(){

		// prepare data, initialize DAOs
		Car car1 = new Car();
		car1.setCarType(CarType.CompactCar);
		Car car2 = new Car();
		car2.setCarType(CarType.CompactCar);
		Car car3 = new Car();
		car3.setCarType(CarType.MidCar);
		
		CarDAO carDAO = new CarDAO();
		carDAO.addCar(car1);
		carDAO.addCar(car2);
		carDAO.addCar(car3);

		Customer customer1 = new Customer();
		customer1.setCustomerLoginId("customerLoginId_1");
		Customer customer2 = new Customer();
		customer2.setCustomerLoginId("customerLoginId_2");
		Customer customer3 = new Customer();
		customer3.setCustomerLoginId("customerLoginId_3");
		Customer customer4 = new Customer();
		customer4.setCustomerLoginId("customerLoginId_4");
		
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.addCustomer(customer1);
		customerDAO.addCustomer(customer2);
		customerDAO.addCustomer(customer3);
		customerDAO.addCustomer(customer4);
		
		CarRentalDAO carRentalDAO = new CarRentalDAO();
		
		// initialize services
		customerAccountService = new CustomerAccountServiceImpl();
		customerAccountService.setCustomerDAO(customerDAO);
		
		carRentalService = new CarRentalServiceImpl();
		carRentalService.setCarDAO(carDAO);
		carRentalService.setCarRentalDAO(carRentalDAO);
		carRentalService.setCustomerDAO(customerDAO);
		
    }
    
    @Test
    public void reserveCarTest() throws Exception {

    	boolean result;
    	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int customerId = customerAccountService.getCustomerId("customerLoginId_1");
		OrderRequest orderRequest1 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-01"), sdf.parse("2018-08-07"));
		result = carRentalService.reserveCar(orderRequest1);
		
		assertTrue("customerLoginId_1 should be able to reserve a compact car from 2018-08-01 to 2018-08-07", result);

		customerId = customerAccountService.getCustomerId("customerLoginId_2");
		OrderRequest orderRequest2 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-15"), sdf.parse("2018-08-20"));
		result = carRentalService.reserveCar(orderRequest2);
		
		assertTrue("customerLoginId_2 should be able to reserve a compact car from 2018-08-15 to 2018-08-20", result);
		
		customerId = customerAccountService.getCustomerId("customerLoginId_3");
		OrderRequest orderRequest3 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-07"), sdf.parse("2018-08-15"));
		result = carRentalService.reserveCar(orderRequest3);
		
		assertFalse("customerLoginId_3 should not be able to reserve a compact car from 2018-08-07 to 2018-08-15", result);
		
		OrderRequest orderRequest4 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-09"), sdf.parse("2018-08-16"));
		result = carRentalService.reserveCar(orderRequest4);
		
		assertTrue("customerLoginId_3 should be able to reserve a compact car from 2018-08-09 to 2018-08-16", result);
		
		customerId = customerAccountService.getCustomerId("customerLoginId_4");
		OrderRequest orderRequest6 = new OrderRequest(customerId, CarType.MidCar, sdf.parse("2018-08-08"), sdf.parse("2018-08-14"));
		result = carRentalService.reserveCar(orderRequest6);   
		
		assertTrue("customerLoginId_4 should be able to reserve a mid car from 2018-08-08 to 2018-08-14", result);
		
    }
    
}
