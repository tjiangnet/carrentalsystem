package org.carrentalsystem.Request;

import java.util.Date;

import org.carrentalsystem.model.data.CarType;

public class OrderRequest {

	private Integer customerId;
	private CarType carType;
	private Date startDate;
	private Date endDate;
	
	public OrderRequest(Integer customerId, CarType carType, Date startDate, Date endDate){
		this.customerId = customerId;
		this.carType = carType;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Integer getCustomerId(){
		return customerId;
	}
	
	public CarType getCarType(){
		return carType;
	}
	
	public Date getStartDate(){
		return startDate;
	}

	public Date getEndDate(){
		return endDate;
	}

}
