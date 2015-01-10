package com.javahash.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javahash.spring.model.UserDetails;

@Controller
public class LoginController {
	
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView loginDetails() {
		      return new ModelAndView("login/login", "command", new UserDetails());
		   }

		@RequestMapping(value="login/submitLogin",method=RequestMethod.POST)
		public String login(@ModelAttribute("command")UserDetails userDetails,ModelMap modelMap){
			System.out.println(userDetails);
			modelMap.addAttribute("username", userDetails.getUsername());
			return "login/loginSuccess";
			
			
		}
}
