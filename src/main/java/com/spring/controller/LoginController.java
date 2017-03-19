package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.constant.DBQuery;
import com.spring.util.DBManager;

@Controller
public class LoginController {
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean == null || loginBean.getUserName() == null || loginBean.getPassword() == null) {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
		boolean isValid = false;
		try {
			isValid = validateUserCredentials(loginBean);
		} catch (SQLException e) {
			model.addAttribute("error", "Unexpected error occurred during login. Please try later");
			return "login";
		}
		
		if(!isValid){
			model.addAttribute("error", "Username and password combination is not correct. Please login again with correct user name and password");
			return "login";
		}
		return "userhomepage";
	}

	private boolean validateUserCredentials(LoginBean loginBean) throws SQLException {
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = connection.prepareStatement(DBQuery.VALIDATE_USER_CREDENTIALS);
		statement.setString(1, loginBean.getUserName());
		statement.setString(2, loginBean.getPassword());
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			return resultSet.getInt(1) == 1;
		}
		return false;
	}
}
