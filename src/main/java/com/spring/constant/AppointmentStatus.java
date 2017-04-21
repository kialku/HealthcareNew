package com.spring.constant;

public enum AppointmentStatus {

	SCHEDULED("scheduled"), 
	
	COMPLETED("completed"), 
	
	CANCELLED("canceled");
	
	private String status;
	
	private AppointmentStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public AppointmentStatus getEnumConstant(String status){
		
		AppointmentStatus value = null;
		for(AppointmentStatus a : values()){
			if(a.getStatus().equalsIgnoreCase(status))
				return a;
		}	
		return value;
	}
}
