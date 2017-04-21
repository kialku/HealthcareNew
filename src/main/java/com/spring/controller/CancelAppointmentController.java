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
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.constant.AppointmentStatus;
import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;

@Controller
public class CancelAppointmentController extends AbstractController{


		@RequestMapping(value="/cancelappointment", method=RequestMethod.GET)
		public String getCancelAppointmentPage(Model model){
			return "cancelappointment";
		}
		
		@RequestMapping(value="/cancelappointment", method=RequestMethod.POST)
		public String doCancelAppointment(Model model, @ModelAttribute CancelAppointmentDTO cancelDetails, @RequestParam("aid") String aid){
			boolean isValidUser;
			try{
				isValidUser = validateUserCredentials(cancelDetails.getUserName(), cancelDetails.getPassword());
			}catch(Exception ex){
				ex.printStackTrace();
				isValidUser = false;
			}

			if(!isValidUser){
				model.addAttribute("footerMessage", "Username and password combination is not correct. Please login again with correct user name and password");
				return "cancelappointment";
			}

			boolean isValidAppointmentID;
			try {
				isValidAppointmentID = isValidAppointmentID(aid, cancelDetails.getUserName());
			} catch (SQLException e) {
				e.printStackTrace();
				isValidAppointmentID = false;
			}

			if(!isValidAppointmentID){
				model.addAttribute("footerMessage", "Appointment id is not correrct or appointment is not scheduled. Please provide an appointment ID that is scheduled");
				return "cancelappointment";
			}

			try {
				cancelAppointment(aid);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("footerMessage", "Error occurred while trying to delete an appointment. Please try again");
				return "cancelappointment";
			}

			model.addAttribute("appointmentid", aid);
			return "cancelsuccess";

		}

		private void cancelAppointment(String appointmentID) throws Exception {
			Connection connection = DBManager.getInstance().getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(DBQuery.CANCEL_APPOINTMENT);
			prepareStatement.setString(1, AppointmentStatus.CANCELLED.getStatus());
			prepareStatement.setString(2, appointmentID);
			prepareStatement.executeUpdate();
			
		}

		private boolean isValidAppointmentID(String appointmentID, String userID) throws SQLException{
			
			Connection connection = DBManager.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement(DBQuery.IS_VALID_APPOINTMENT);
			statement.setString(1, appointmentID);
			statement.setString(2, userID);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt(1) == 1;
			}
			return false;
		}
}
