package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.LibraryDao;
import com.example.demo.model.UserInfo;

@Service
public class LibraryService {

	@Autowired
	LibraryDao dao;
	
	public ArrayList<UserInfo> getData(){
		return  dao.showAllUser();
	}
	public UserInfo getUser(int userId){
		return  dao.displayUser(userId);
	}
	public void addNewUser(UserInfo user) {
		dao.addUser(user);
	}
	public String validateUser(int userId, String password) {
		// TODO Auto-generated method stub
		return dao.validateUser(userId,password);
	}
	
	
	
}
