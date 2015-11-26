package com.mahdidoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahdidoc.exception.DocException;
import com.mahdidoc.model.UserProfile;
import com.mahdidoc.model.UserStatusEnum;
import com.mahdidoc.service.IUserRoleService;
import com.mahdidoc.service.IUserService;

@Controller
public class RegistrationController {

	@Autowired
	IUserService userService;	

	@Autowired
	IUserRoleService userRoleService;
	
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registrationPage(Model model) throws DocException {
		model.addAttribute("user", new UserProfile());
		model.addAttribute("userRoles", userRoleService.getList());
		model.addAttribute("status", new UserStatusEnum[]{UserStatusEnum.ACTIVE, UserStatusEnum.DEACTIVE});

		return "registrationPage";
	}

	@RequestMapping(value= "/user/signup", method = RequestMethod.POST)
	public String addSignup(@ModelAttribute("user") UserProfile u) throws DocException{
		userService.saveUser(u);			
		return "redirect:/login";


	}
}
