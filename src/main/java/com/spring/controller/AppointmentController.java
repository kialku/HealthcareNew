package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.constant.AppointmentStatus;
import com.spring.constant.DBQuery;
import com.spring.healthcare.util.DBManager;
import com.spring.healthcare.util.Utilities;

@Controller
public class AppointmentController extends AbstractController{
	
	Logger logger = Logger.getLogger(AppointmentController.class.getName());

	@RequestMapping(value="/newappointment", method=RequestMethod.GET)
	public String sendAppointmentPage(){
		return "bookappointment";
	}
	
	@RequestMapping(value="/newappointment", method=RequestMethod.POST)
	public String getAppointmentDetails(Model  model, @ModelAttribute AppointmentDTO appointmentDetails){
		
		if(!isValidCredentials(appointmentDetails)){
			model.addAttribute("footerMessage", "Error : Username and password combination is not correct.");
			return "bookappointment";
		}
		
		if(!isDateAndTimeValid(appointmentDetails)){
			model.addAttribute("footerMessage", "Error : Could not book an appointment. You already have an appointment for this date and time. <br> Please select different date and time and try again");
			return "bookappointment";
		}
		
		try{
			String appointmentID = createaNewAppointment(appointmentDetails);
			model.addAttribute("aid", appointmentID);
			model.addAttribute("adate", appointmentDetails.getDoa());
			model.addAttribute("atime", appointmentDetails.getToa());
			return "appointmentsuccess";
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return "generalerror";
	}

	private boolean isDateAndTimeValid(AppointmentDTO appointmentDetails) {
		return true;
	}

	private String createaNewAppointment(AppointmentDTO appointmentDetails) throws SQLException{
		
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement(DBQuery.ADD_NEW_APPOINTMENT);
		String appointmentID = Utilities.randomString(10);
		Timestamp appointmentDtTm = combineDateAndTime(appointmentDetails);
		
		String userId = getUserID(appointmentDetails.getEmail());
		prepareStatement.setString(1, appointmentID);
		
		prepareStatement.setString(2, userId);
		
		prepareStatement.setTimestamp(3, appointmentDtTm);
		prepareStatement.setString(4, appointmentDetails.getServiceName());
		prepareStatement.setString(5, appointmentDetails.getServiceProvider());
		prepareStatement.setString(6, AppointmentStatus.SCHEDULED.getStatus());
		prepareStatement.execute();
		logger.info("New appointment booked. Appointment id " + appointmentID);
		return appointmentID;
	}

	private Timestamp combineDateAndTime(AppointmentDTO appointmentDetails) {
		Timestamp timestamp = null;
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
			Date parsedDate = (Date) dateFormat.parse(appointmentDetails.getDoa() + " "+ appointmentDetails.getToa()+":00");
			timestamp = new Timestamp(parsedDate.getTime());
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return timestamp;
	}

	private boolean isValidCredentials(AppointmentDTO appointmentDTO) {
		try{
			return validateUserCredentials(appointmentDTO.getEmail(), appointmentDTO.getPassword());
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
