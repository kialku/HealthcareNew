package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppointmentController {

	@RequestMapping(value="/newappointment", method=RequestMethod.GET)
	public String sendAppointmentPage(){
		return "bookappointment";
	}
	
	@RequestMapping(value="/newappointment", method=RequestMethod.POST)
	@ResponseBody
	public String getAppointmentDetails(Model  model, @ModelAttribute NewAppointmentBean appointmentDetails){
		return appointmentDetails.toString();
	}
}
