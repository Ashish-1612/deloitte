package com.deloitte.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.demo.Dao.DesignationDAO;
import com.deloitte.demo.model.LoginInfo;

@Service
public class DesignationService {
    @Autowired   
	DesignationDAO dao;
    
	public LoginInfo validateUser(int userId,String password) {
		return dao.validateUser(userId, password);
		
	}
}
