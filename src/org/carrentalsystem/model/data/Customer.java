package org.carrentalsystem.model.data;

public class Customer {

	private Integer customerId; // id
	private String customerLoginId;
	private String firstName;
	private String lastName;
	// other customer profile information
	
	
	//getters and setters
	public Integer getCustomerId(){
		return customerId;
	}
	
	public void setCustomerId(Integer customerId){
		this.customerId = customerId;
	}
	
	public String getCustomerLoginId(){
		return customerLoginId;
	}
	
	public void setCustomerLoginId(String customerLoginId){
		this.customerLoginId = customerLoginId;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}	

}
