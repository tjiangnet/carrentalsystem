package org.carrentalsystem.Request;

public class AssignRequest {

	private Integer customerId;
	private Integer carId;

	public AssignRequest(Integer customerId, Integer carId){
		this.customerId = customerId;
		this.carId = carId;
	}
	
	public Integer getCustomerId(){
		return customerId;
	}
	
	public Integer getCarId(){
		return carId;
	}
}
