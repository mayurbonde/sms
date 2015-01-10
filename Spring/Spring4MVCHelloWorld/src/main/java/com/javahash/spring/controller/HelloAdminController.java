package com.javahash.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloAdminController {

	@RequestMapping("/Admin")
	public String sayHello( @RequestParam(value="name",defaultValue="Hello Admin")String name,Model model){
		model.addAttribute("name", name);
		return "admin/adminHome";
		
	}
}
