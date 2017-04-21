package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;

@Controller
public class MyAppointmentsController extends AbstractController{

	@RequestMapping(value="/viewappointments", method=RequestMethod.GET)
	public String showMyAppointmentsPage(Model model){
		return "viewappointment";
	}
	
	
	@RequestMapping(value="/viewappointments", method=RequestMethod.POST)
	public String showMyAppointmentsDeatils(Model model, @ModelAttribute("loginBean") LoginBean loginBean){
		
		if(!isValidCredentials(loginBean)){
			model.addAttribute("footerMessage", "Error : Username and password combination is not correct.");
			return "viewappointment";
		}
		
		String userId = getUserID(loginBean.getUserName());
		ResultSet resultset = getUserAppointment(userId);
		if(resultset == null){
			model.addAttribute("tabledata", "No records found");
			return "userappointment";
		}
		StringBuilder table = new StringBuilder();
		table.append("<table>");
		table.append("<tr>");
		table.append("<th> AppointmentID </th>");
		table.append("<th> Appointment Date and Time </th>");
		table.append("<th> Service Type </th>");
		table.append("<th> Service Provider </th>");
		table.append("<th> status </th>");
		table.append("</tr>");
		
		try { 
			while(resultset.next()){
				table.append("<tr>");
				table.append("<td>" + resultset.getString("appointmentid") + "</td>");
				table.append("<td>" + resultset.getString("appointmentdttm") + "</td>");
				table.append("<td>" + resultset.getString("service") + "</td>");
				table.append("<td>" + resultset.getString("provider") + "</td>");
				table.append("<td>" + resultset.getString("status") + "</td>");
				table.append("</tr>");
			}

		}catch(Exception ex){
			table.append(ex.getMessage());
		}
		table.append("</table>");
		
		model.addAttribute("tabledata", table.toString());
		return "userappointment";
	}
	
	private ResultSet getUserAppointment(String userId) {
		ResultSet resultSet = null;
		try{
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(DBQuery.READ_USER_APPOINTMENTS);
		prepareStatement.setString(1, userId);
		resultSet = prepareStatement.executeQuery();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultSet;
	}


	private boolean isValidCredentials(LoginBean loginBean) {
		try{
			return validateUserCredentials(loginBean.getUserName(), loginBean.getPassword());
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
