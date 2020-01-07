package com.deloitte.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deloitte.demo.model.LoginInfo;
import com.deloitte.demo.service.DesignationService;

@Controller
@ResponseBody
public class DesignationController {
	
	@Autowired
	DesignationService service;
	
	@PostMapping("/login")
	public LoginInfo validateUser(@RequestBody LoginInfo user) {
		System.out.println(user);
		return (service.validateUser(user));
		
	}
	
	

}
