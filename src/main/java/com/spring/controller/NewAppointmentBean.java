package com.spring.controller;

import java.sql.Date;

public class NewAppointmentBean {

	private Date date;
	
	private String serviceName;
	
	private String serviceProvider;

	public NewAppointmentBean(Date date, String serviceName, String serviceProvider) {
		super();
		this.date = date;
		this.serviceName = serviceName;
		this.serviceProvider = serviceProvider;
	}
	
	public NewAppointmentBean() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	@Override
	public String toString() {
		return "NewAppointmentBean [date=" + date + ", serviceName=" + serviceName + ", serviceProvider="
				+ serviceProvider + "]";
	}
	
	
}
