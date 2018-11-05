package org.carrentalsystem.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.carrentalsystem.model.data.CarRental;
import org.carrentalsystem.model.data.CarType;

public class CarRentalDAO {

	Map<Integer, CarRental> carRentals = new HashMap<Integer, CarRental>();
	static int carRentalId = 0; //identifier generator
	
	public void addCarRental(CarRental newCarRental){
		carRentalId ++;
		newCarRental.setRentalId(carRentalId);
		carRentals.put(carRentalId, newCarRental);
	}
	
	public void updateCarRental(CarRental carRental){
		// assume it is same obejct in carRentals, don't anything here
	}
	
	public void removeCarRental(Integer carRentalId){
		carRentals.remove(carRentalId);
	}
	
	public CarRental getCarRental(Integer carRentalId){
		return carRentals.get(carRentalId);
	}
	
	public List<CarRental> getCarRentalsByCarType(CarType carType){
		List<CarRental> carRentalsByCarType = new ArrayList<CarRental>(carRentals.values());
		return carRentalsByCarType.stream()
				.filter(c -> c.getCarType()==carType)
				.collect(Collectors.toList());
	}
	
	public CarRental getCarRentalByCustomerId(Integer customerId){
		CarRental customerCarRental = null;
		
		for(CarRental carRental : carRentals.values()){
			if(carRental.getCustomerId() == customerId){
				customerCarRental = carRental;
				break;
			}
		}
		
		return customerCarRental;
	}
}
