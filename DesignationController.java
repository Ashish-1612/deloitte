package com.deloitte.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deloitte.demo.model.LoginInfo;
import com.deloitte.demo.service.DesignationService;

@Controller
public class DesignationController {
	
	@Autowired
	DesignationService service;
	
	@PostMapping("/login")
	public LoginInfo validateUser(@RequestParam("userId") int userId,@RequestParam("password") String password) {
		return service.validateUser(userId,password);
		
	}

}
