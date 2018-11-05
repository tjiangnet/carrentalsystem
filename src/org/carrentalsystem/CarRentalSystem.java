package org.carrentalsystem;

import java.text.SimpleDateFormat;

import org.carrentalsystem.Request.OrderRequest;
import org.carrentalsystem.model.dao.CarDAO;
import org.carrentalsystem.model.dao.CarRentalDAO;
import org.carrentalsystem.model.dao.CustomerDAO;
import org.carrentalsystem.model.data.Car;
import org.carrentalsystem.model.data.CarType;
import org.carrentalsystem.model.data.Customer;
import org.carrentalsystem.service.impl.CarRentalServiceImpl;
import org.carrentalsystem.service.impl.CustomerAccountServiceImpl;

public class CarRentalSystem {

	public static void main(String[] args) throws Exception {
		System.out.println("test CarRentalSystem!");
		
		// prepare data and initialize DAOs
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
		
		CustomerAccountServiceImpl customerAccountService = new CustomerAccountServiceImpl();
		customerAccountService.setCustomerDAO(customerDAO);
		CarRentalServiceImpl carRentalService = new CarRentalServiceImpl();
		carRentalService.setCarDAO(carDAO);
		carRentalService.setCarRentalDAO(carRentalDAO);
		carRentalService.setCustomerDAO(customerDAO);
				
		System.out.println("call Services!");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int customerId = customerAccountService.getCustomerId("customerLoginId_1");
		OrderRequest orderRequest1 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-01"), sdf.parse("2018-08-07"));
		carRentalService.reserveCar(orderRequest1);

		customerId = customerAccountService.getCustomerId("customerLoginId_2");
		OrderRequest orderRequest2 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-15"), sdf.parse("2018-08-20"));
		carRentalService.reserveCar(orderRequest2);
		
		customerId = customerAccountService.getCustomerId("customerLoginId_3");
		OrderRequest orderRequest3 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-07"), sdf.parse("2018-08-15"));
		carRentalService.reserveCar(orderRequest3);
		OrderRequest orderRequest4 = new OrderRequest(customerId, CarType.CompactCar, sdf.parse("2018-08-09"), sdf.parse("2018-08-16"));
		carRentalService.reserveCar(orderRequest4);
		
		customerId = customerAccountService.getCustomerId("customerLoginId_4");
		OrderRequest orderRequest6 = new OrderRequest(customerId, CarType.MidCar, sdf.parse("2018-08-08"), sdf.parse("2018-08-14"));
		carRentalService.reserveCar(orderRequest6);
				
	}
}
