package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;
import com.spring.healthcare.util.Utilities;

/**
 * 
 * @author Kedar
 *
 */
@Controller
public class SignupController {
	
	Logger logger = Logger.getLogger(SignupController.class.getName());

	/**
	 * Render a signup form to the person as HTML in their web browser.
	 */
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupForm(WebRequest request) {
		return "signup";
	}

	/**
	 * Process a signup form submission.
	 * Delegate to a {@link SignupHelper} to actually complete the signin transaction.
	 * Redirects the new member to the application home page on successful sign-in.
	 */
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(Model model, @ModelAttribute SignupDTO signUpInfo) {
		boolean isValidData;
		try{
			isValidData = isRegisterInfoValid(signUpInfo);
		}catch(SQLException ex){
			isValidData = false;
		}
		if(isValidData){
			try {
				persistNewUserInfo(signUpInfo);
			} catch (Exception e ) {
				e.printStackTrace();
				model.addAttribute("footerMessage", e.getMessage());
				return "signup";
			} 
		}else {
			model.addAttribute("footerMessage", "Email id is already used");
			return "signup";
		}
		model.addAttribute("msg", signUpInfo.getFirstName());
		return "signupSucess";
	}

	private void persistNewUserInfo(SignupDTO signUpInfo) throws SQLException, ParseException {
		DateFormat df  = new SimpleDateFormat("dd-MM-yyyy");
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(DBQuery.CREATE_NEW_USER_QUERY);
		String userId = Utilities.randomString(10);
		prepareStatement.setString(1, userId);
		prepareStatement.setString(2, signUpInfo.getFirstName());
		prepareStatement.setString(3, signUpInfo.getLastName());
		prepareStatement.setDate(4, new java.sql.Date(df.parse(signUpInfo.getDob()).getTime()));
		prepareStatement.setString(5, "M");
		prepareStatement.setString(6, signUpInfo.getMobile());
		prepareStatement.setString(7, signUpInfo.getEmail());
		prepareStatement.setString(8, signUpInfo.getCity());
		prepareStatement.setString(9, signUpInfo.getPincode());
		prepareStatement.setString(10, "customer address");

		prepareStatement.execute();
		logger.info("New user id" + userId);

		// insert user specific info like address and password

		prepareStatement = connection.prepareStatement(DBQuery.ADD_USER_PASSWORD);
		prepareStatement.setString(1, userId);
		prepareStatement.setString(2, signUpInfo.getPassword());
		prepareStatement.execute();
	}

	private boolean isRegisterInfoValid(SignupDTO signUpInfo) throws SQLException {
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement statement = connection.prepareStatement(DBQuery.IS_EMAIL_USED);
		statement.setString(1, signUpInfo.getEmail());
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			return resultSet.getInt(1) == 0;
		}
		return false;
	}	
}