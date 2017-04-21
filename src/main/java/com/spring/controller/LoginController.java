package com.spring.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController extends AbstractController{
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String init(Model model) {
		return "login";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean == null || loginBean.getUserName() == null || loginBean.getPassword() == null) {
			model.addAttribute("footerMessage", "Please enter Details");
			return "login";
		}
		boolean isValid = false;
		try {
			isValid = validateUserCredentials(loginBean.getUserName(), loginBean.getPassword());
		} catch (SQLException e) {
			model.addAttribute("footerMessage", "Unexpected error occurred while trying to login. Please try later");
			return "login";
		}
		
		if(!isValid){
			model.addAttribute("footerMessage", "Username and password combination is not correct. Please login again with correct user name and password");
			return "login";
		}
		return "redirect:/home";
	}

	
}
