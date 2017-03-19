package com.spring.constant;

public final class DBQuery {

	private DBQuery(){
		// so that no one creates an instane of this class
	}
	
	public static final String CREATE_NEW_USER_QUERY = "INSERT INTO USER (USERID, FNAME, LNAME, DOB, GENDER, PHONENUM, MAILID, CITY, PINCODE, ADDRESS)"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	public static final String ADD_USER_PASSWORD = "INSERT INTO PASSWORD (USERID, PASSWORD) VALUES (?,?)";
	
	public static final String VALIDATE_USER_CREDENTIALS = "SELECT COUNT(1) FROM PASSWORD WHERE USERID = (SELECT USERID FROM USER WHERE MAILID = ?) AND PASSWORD = ?";
	
}
