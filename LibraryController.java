package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserInfo;
import com.example.demo.services.LibraryService;

@Controller
@ResponseBody
public class LibraryController {

	@Autowired
	LibraryService service;

	@RequestMapping()
	public ArrayList<UserInfo> getData() {
		return service.getData();
	}

	@GetMapping("/user")
	public UserInfo getUser(@RequestParam("userId") int userId) {
		return service.getUser(userId);
	}

	@PostMapping("/addUser")
	public void addNewUser(@RequestBody UserInfo user1) {
		service.addNewUser(user1);
	}

	@GetMapping("/msg")
	public ModelAndView myMethod() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("myjsp");
        modelAndView.addObject("obj",getUser(1001));
		return modelAndView;
	}
	@GetMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@GetMapping("/login")
	public ModelAndView  checkUser(@RequestParam("userId") int userId,@RequestParam("password") String password) {
		ModelAndView modelAndView= new ModelAndView();
		String message=service.validateUser(userId,password);
		if(message!=null) {
		modelAndView.setViewName("myjsp");
		modelAndView.addObject("name",message);
		}
		else {
			modelAndView.setViewName("login");
			modelAndView.addObject("log","user is not valid");
		}
		return modelAndView;
	}

}
