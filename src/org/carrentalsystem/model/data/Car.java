package org.carrentalsystem.model.data;

public class Car {

	private Integer carId;  // id
	private CarType carType;
	
	//getters and setters
	public Integer getCarId(){
		return carId;
	}
	
	public void setCarId(Integer carId){
		this.carId = carId;
	}
	
	public CarType getCarType(){
		return carType;
	}
	
	public void setCarType(CarType carType){
		this.carType = carType;
	}
	
}
