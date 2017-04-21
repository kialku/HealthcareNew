package com.spring.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;


@Controller
public class ViewProfileController extends AbstractController{

	@RequestMapping(value = "/viewprofile", method = RequestMethod.GET)
	public String viewProfile(Model model){
		return "viewprofile";
	}
	
	
	@RequestMapping(value = "/viewprofile", method = RequestMethod.POST)
	public String getUserProfile(Model model, @ModelAttribute("loginBean") LoginBean loginBean){
		
		boolean isCorrectUser;
		
		try{
			isCorrectUser = validateUserCredentials(loginBean.getUserName(), loginBean.getPassword());
		}catch(Exception ex){
			ex.printStackTrace();
			isCorrectUser = false;
		}
		
		if(!isCorrectUser){
			model.addAttribute("footerMessage", "Username and password combination is not correct. Please login again with correct user name and password");
			return "viewprofile";
		}
		try {
			Map<String, String> userDetails = getAttributes(loginBean.getUserName());
			model.addAllAttributes(userDetails);
			return "userprofile";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("footerMessage", "Could not fetch user profile. Please try again");
		return "viewprofile";
	}

	private Map<String, String> getAttributes(String userName) throws SQLException {

		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement;
		Map<String, String> profile = null;
		statement = connection.prepareStatement(DBQuery.READ_USER_DETAILS);
		statement.setString(1, userName);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			profile  = populateProfileWithResults(resultSet);
		}
		return profile;
	}


	private Map<String, String> populateProfileWithResults(ResultSet resultSet) throws SQLException{
		Map<String, String> profile = new HashMap<String, String>();
		profile.put("firstname", resultSet.getString("fname"));
		profile.put("lastname", resultSet.getString("lname"));
		profile.put("emailId", resultSet.getString("mailId"));
		profile.put("dob", resultSet.getDate("dob").toString());
		profile.put("phonenumber", resultSet.getLong("phoneNum")+"");
		profile.put("pincode", resultSet.getLong("pincode") + "");
		profile.put("city", resultSet.getString("city"));
		profile.put("signupdate", new Date(System.currentTimeMillis()).toString());
		profile.put("noa", "10");
		return profile;
	}

}
