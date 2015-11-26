package com.mahdidoc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
public class LoginController {

	@Autowired
	IUserService userService;	

	@Autowired
	IUserRoleService userRoleService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("message", "Enter your username/password:");
		
		return "loginPage";
	} 

	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) throws DocException {
		User activeUser = (User) ((Authentication) principal).getPrincipal(); 
		model.addAttribute("title", "Admin");
		model.addAttribute("message", "Admin Page - This is protected page!");
		model.addAttribute("user", userService.getRowByName("username", activeUser.getUsername()));
		model.addAttribute("userRoles", userRoleService.getList());
		model.addAttribute("status", new UserStatusEnum[]{UserStatusEnum.ACTIVE, UserStatusEnum.DEACTIVE});
		model.addAttribute("list", userService.getList());
		return "adminPage";
	}
	
	@RequestMapping(value = "userInfo", method = RequestMethod.GET)
	public String loginPage(Model model, Principal principal) throws DocException {
		model.addAttribute("title", "User Info"); 
		User activeUser = (User) ((Authentication) principal).getPrincipal(); 
		model.addAttribute("message",
				"User Info - This is protected page!. Hello " + activeUser.getUsername());
		model.addAttribute("user", userService.getRowByName("username", activeUser.getUsername()));
		model.addAttribute("userRoles", userRoleService.getList());
		model.addAttribute("status", new UserStatusEnum[]{UserStatusEnum.ACTIVE, UserStatusEnum.DEACTIVE});
		return "userInfoPage";
	}

	
}