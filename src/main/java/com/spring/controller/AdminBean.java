package com.spring.controller;

public class AdminBean {

	private String userName;
	
	private String password;
	
	private String action;

	@Override
	public String toString() {
		return "AdminBean [username=" + userName + ", password=" + password
				+ ", action=" + action + "]";
	}

	public AdminBean(String username, String password, String action) {
		super();
		this.userName = username;
		this.password = password;
		this.action = action;
	}

	public AdminBean() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
}
