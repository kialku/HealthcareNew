package com.spring.controller;

public class AppointmentDTO {

	private String doa;
	
	private String toa;
	
	private String serviceName;
	
	private String serviceProvider;
	
	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoa() {
		return doa;
	}

	public void setDoa(String doa) {
		this.doa = doa;
	}

	public String getToa() {
		return toa;
	}

	public void setToa(String toa) {
		this.toa = toa;
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

	public AppointmentDTO(String doa, String toa, String serviceName,
			String serviceProvider) {
		super();
		this.doa = doa;
		this.toa = toa;
		this.serviceName = serviceName;
		this.serviceProvider = serviceProvider;
	}

	public AppointmentDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AppointmentDTO [doa=" + doa + ", toa=" + toa + ", serviceName="
				+ serviceName + ", serviceProvider=" + serviceProvider
				+ ", email=" + email + ", password=" + password + "]";
	}	
	
}
