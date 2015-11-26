package com.mahdidoc.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenericErrorController {

	@RequestMapping("404")
	public ModelAndView pageNotFound() {		
		return new ModelAndView("error").addObject("message", "Page not found.");
	}
	
	@RequestMapping(value={"503","500"})
	public ModelAndView internalServerError() {		
		return new ModelAndView("error").addObject("message", "There is some internal server error.");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	   public String accessDenied(Model model, Principal principal) {
	       model.addAttribute("title", "Access Denied!");
	 
	       if (principal != null) {
	           model.addAttribute("message", "Hi " + principal.getName()
	                   + "<br> You do not have permission to access this page!");
	       } else {
	           model.addAttribute("message",
	                   "You do not have permission to access this page!");
	       }
	       return "error";
	   }
}
