package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;

import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;

@Controller
public abstract class AbstractController {

	protected boolean validateUserCredentials(String email, String password) throws SQLException {
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = connection.prepareStatement(DBQuery.VALIDATE_USER_CREDENTIALS);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			return resultSet.getInt(1) == 1;
		}
		return false;
	}
	
	protected String getUserID(String email) {
		try{
			Connection connection = DBManager.getInstance().getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(DBQuery.READ_USER_DETAILS);
			prepareStatement.setString(1, email);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("userid");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}

}
