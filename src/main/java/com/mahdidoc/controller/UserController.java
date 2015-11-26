package com.mahdidoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahdidoc.exception.DocException;
import com.mahdidoc.model.UserProfile;
import com.mahdidoc.model.UserStatusEnum;
import com.mahdidoc.service.IUserRoleService;
import com.mahdidoc.service.IUserService;
 
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	IUserRoleService userRoleService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model model) throws DocException {
		model.addAttribute("user", new UserProfile());
		model.addAttribute("userRoles", userRoleService.getList());
		model.addAttribute("status", new UserStatusEnum[]{UserStatusEnum.ACTIVE, UserStatusEnum.DEACTIVE});
		model.addAttribute("list", this.userService.getList());
		return "user";
	}
	
	//For add and update person both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserProfile u) throws DocException{
		userService.saveUser(u);		
		return "redirect:/list";		
	}	
	
		
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) throws DocException{		
        this.userService.deleteRow(id);
        return "redirect:/list";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) throws DocException{
        model.addAttribute("user", this.userService.getRowById(id));
        model.addAttribute("userRoles", userRoleService.getList());
        model.addAttribute("status", new UserStatusEnum[]{UserStatusEnum.ACTIVE, UserStatusEnum.DEACTIVE});
        model.addAttribute("list", this.userService.getList());
        return "user";
    }
	

    
}