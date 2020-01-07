package com.deloitte.demo.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.demo.Dao.DesignationDAO;
import com.deloitte.demo.model.LoginInfo;

@Service
public class DesignationService {
	@Autowired
	DesignationDAO dao;
	Scanner sc = new Scanner(System.in);

	public LoginInfo validateUser(LoginInfo user) {
		return dao.validateUser(user);

	}

	public String setDesignation(int InterviewScore,int finalPercentage) {
		if (InterviewScore >= 8) {
			if (finalPercentage >= 80) {
                   System.out.println("Deloitte Consultant");
			} else if (finalPercentage >= 70) {
				System.out.println("System engineer");
			} else if (finalPercentage >= 60) {
				System.out.println("Associate Analyst");
			}
		} else if (InterviewScore >= 7) {
			if (finalPercentage >= 80) {
				System.out.println("System engineer");
			} else if (finalPercentage >= 70) {
				System.out.println("Audit & Risk Consultant");
			} else if (finalPercentage >= 60) {
				System.out.println("Business Technology Analyst");
			}

		} else if (InterviewScore >= 6) {
			if (finalPercentage >= 80) {
				System.out.println("Audit & Risk Consultant");
			} else if (finalPercentage >= 70) {
				System.out.println("Junior Executive");
			} else if (finalPercentage >= 60) {
				System.out.println("Computer Operator");
			}
		}
		return null;
	}
	public Double setPackage(String designation,String qualification) {
		double salaryPackage = 300000.00;
		if(qualification.equals("Bachelor")) {
			if(designation.equals("Deloitte Consultant") | designation.equals("System engineer") | designation.equals("Audit & Risk Consultant")) {
				salaryPackage=500000.00;
			}
			else if(designation.equals("Business Technology Analyst") | designation.equals("Associate Analyst")) {
				salaryPackage=400000.00;
			}
			else if(designation.equals("Junior Executive") | designation.equals("Computer Operator")) {
				salaryPackage=330000.00;
			}
			
		}
		else if(qualification.equals("Master")) {
			if(designation.equals("Deloitte Consultant") | designation.equals("System engineer") | designation.equals("Audit & Risk Consultant")) {
				salaryPackage=700000.00;
			}
			else if(designation.equals("Business Technology Analyst") | designation.equals("Associate Analyst")) {
				salaryPackage=570000.00;
			}
			else if(designation.equals("Junior Executive") | designation.equals("Computer Operator")) {
				salaryPackage=450000.00;
			}
			
		}
		return salaryPackage;
	}
}
