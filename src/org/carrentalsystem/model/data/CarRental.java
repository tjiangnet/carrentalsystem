package org.carrentalsystem.model.data;

import java.util.Date;

public class CarRental {

	private Integer rentalId; // id
	private Integer customerId;
	private CarType carType;
	private Date startDate;
	private Date endDate;
	private RentalStatus rentalStatus;
	private Integer carId;
	private String note;
	
	// getters and setters
	public Integer getRentalId(){
		return rentalId;
	}
	
	public void setRentalId(Integer rentalId){
		this.rentalId = rentalId;
	}
	
	public Integer getCustomerId(){
		return customerId;
	}
	
	public void setCustomerId(Integer customerId){
		this.customerId = customerId;
	}
	
	public CarType getCarType(){
		return carType;
	}
	
	public void setCarType(CarType carType){
		this.carType = carType;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}	
	
	public Integer getCarId(){
		return carId;
	}
	
	public void setCarId(Integer carId){
		this.carId = carId;
	}
	
	public RentalStatus getRentalStatus(){
		return rentalStatus;
	}
	
	public void setRentalStatus(RentalStatus rentalStatus){
		this.rentalStatus = rentalStatus;
	}		
	
	public String getNote(){
		return note;
	}
	
	public void setNote(String note){
		this.note = note;
	}		
	
}
