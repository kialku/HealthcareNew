package com.spring.controller;



public class CancelAppointmentDTO {

	private String aid;
	
	private String userName;
	
	private String password;

	public String getAppointmentID() {
		return aid;
	}

	public void setAppointmentID(String appointmentID) {
		this.aid = appointmentID;
	}

	public CancelAppointmentDTO(String aid, String userName, String password) {
		super();
		this.aid = aid;
		this.userName = userName;
		this.password = password;
	}

	public CancelAppointmentDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "CancelAppointmentDTO [aid=" + aid + ", userName=" + userName
				+ ", password=" + password + "]";
	}

}
