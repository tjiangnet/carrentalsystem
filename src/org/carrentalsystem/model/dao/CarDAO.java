package org.carrentalsystem.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.carrentalsystem.model.data.Car;
import org.carrentalsystem.model.data.CarType;

public class CarDAO {

	Map<Integer, Car> cars = new HashMap<Integer, Car>();
	static int carId = 0; //identifier generator
	
//	// no database here. so pass the data to DAO during initialization
//	public CarDAO(Map<Integer, Car> cars){
//		Objects.requireNonNull(cars, "cars should not be null");
//		this.cars = cars;
//	}
	
	public void addCar(Car newCar){
		carId ++;
		newCar.setCarId(carId);
		cars.put(carId, newCar);
	}
	
	/**
	 * 
	 * @param carId
	 * @return
	 */
	public Car getCar(Integer carId){
		return cars.get(carId);
	}

	/**
	 * 
	 * @param carType
	 * @return
	 */
	public List<Car> getCarsByType(CarType carType){
		List<Car> carsByCarType = new ArrayList<Car>(cars.values());
		return carsByCarType.stream()
				.filter(c -> c.getCarType()==carType)
				.collect(Collectors.toList());
	}
	
}
