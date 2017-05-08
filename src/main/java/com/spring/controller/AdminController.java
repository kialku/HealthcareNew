package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		
		/*try {
			markAppointmentsCompleted();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("footerMessage", "Action could not be completed due to error");
			return "admin";
		}
		model.addAttribute("footerMessage", "Completed appointments marked	");*/
		return "adminHome";
	}
	
	@RequestMapping(value="/admin/task", method=RequestMethod.POST)
	public String doAdminTasks(Model model,@RequestParam("appointmentCompleted") String appointmentCompleted){
		if("on".equalsIgnoreCase(appointmentCompleted)){
			try {
				markAppointmentsCompleted();
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("footerMessage", "Error: Action could not be completed due to error");
				return "admin";
			}
			model.addAttribute("footerMessage", "Selected tasks completed.");
		}
		return "adminHome";
	}
	
	@RequestMapping(value="/admin/viewAppointments", method=RequestMethod.GET)
	public ModelAndView viewAppointments(HttpServletRequest request){
		ModelAndView mav;
		List<AppointmentDTO> appointments = new ArrayList<AppointmentDTO>();
		try {
			appointments = getAllAppointments();
		} catch (Exception e) {
			e.printStackTrace();
			mav = new ModelAndView("error","errormsg",e.getMessage());
			return mav;
		}
		mav = new ModelAndView("appointments","appointments",appointments);
		return mav;
	}
	
	@RequestMapping(value="/admin/listUsers", method=RequestMethod.GET)
	public ModelAndView listUsers(HttpServletRequest request){
		ModelAndView mav;
		List<SignupDTO> users = new ArrayList<SignupDTO>();
		try {
			users = listAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			mav = new ModelAndView("error","errormsg",e.getMessage());
			return mav;
		}
		mav = new ModelAndView("users","users",users);
		return mav;
	}
	
	private List<SignupDTO> listAllUsers() throws SQLException {
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DBQuery.LIST_ALL_USERS);
		ResultSet rs = preparedStatement.executeQuery();
		List<SignupDTO> users = new ArrayList<SignupDTO>();
		while(rs.next()){
			SignupDTO user = new SignupDTO();
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setDob(new SimpleDateFormat("dd-MM-YYYY").format(rs.getDate(4)));
			user.setEmail(rs.getString(7));
			user.setMobile(rs.getString(6));
			user.setCity(rs.getString(9));
			user.setPincode(rs.getString(10));
			users.add(user);
		}
		return users;
	}

	private List<AppointmentDTO> getAllAppointments() throws SQLException {
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DBQuery.FETCH_APPOINTMENTS);
		ResultSet rs = preparedStatement.executeQuery();
		List<AppointmentDTO> appointments = new ArrayList<AppointmentDTO>();
		while(rs.next()){
			AppointmentDTO appointment = new AppointmentDTO();
			Date appointmentDate = rs.getDate(3);
			appointment.setDoa(new SimpleDateFormat("dd-MM-YYYY").format(appointmentDate));
			appointment.setEmail(findEmailById(rs.getString(2)));
			appointment.setToa(new SimpleDateFormat("HH:mm:ss").format(appointmentDate));
			appointment.setServiceName(rs.getString(4));
			appointment.setServiceProvider(rs.getString(5));
			appointments.add(appointment);
		}
		return appointments;
	}

	private String findEmailById(String userId) throws SQLException {
		Connection connection = DBManager.getInstance().getConnection();
		String mailId = null;
		PreparedStatement preparedStatement = connection.prepareStatement(DBQuery.FIND_USER_BY_ID);
		preparedStatement.setString(1,userId);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			mailId = rs.getString(7);
		}
		return mailId;
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
