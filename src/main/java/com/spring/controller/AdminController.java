package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;

@Controller
public class AdminController extends AbstractController{

	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdminPage(Model model){
		return "admin";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public String doAdminTask(Model model, @ModelAttribute AdminBean adminBean){
		
		if(!isValidCredentials(adminBean)){
			model.addAttribute("footerMessage", "Error : Admin Username and password combination is not correct.");
			return "admin";
		}
		
		try {
			markAppointmentsCompleted();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("footerMessage", "Action could not be completed due to error");
			return "admin";
		}
		model.addAttribute("footerMessage", "Completed appointments marked	");
		return "admin";
	}
	
	private void markAppointmentsCompleted() throws Exception{
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DBQuery.MARK_APPOINTMENTS_COMPLETED);
		preparedStatement.executeUpdate();
	}

	private boolean isValidCredentials(AdminBean adminBean) {
		return adminBean.getUserName().equals("admin") && adminBean.getPassword().equals("admin");
	}
}
