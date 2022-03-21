package com.lti.BankingProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginStatus;
import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;
import com.lti.service.CustomerService;
import com.lti.dto.Login;
import com.lti.dto.RegisterStatus;

@RestController
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register.api")
	public RegisterStatus register(@RequestBody Customer customer) {
		try {
			String UserName= customerService.register(customer);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(true);
			status.setRegisteredUserName(UserName);
			return status;
		}catch(CustomerServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	
	@RequestMapping("/login.api")
	public LoginStatus login(@RequestBody Login login){
		try {
			Customer customer= customerService.login(login);
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setUsername(customer.getUserName());
			
			
			return loginStatus;
			
		}catch(CustomerServiceException e) {
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessageIfAny(e.getMessage());
			return loginStatus;
			
		}
	}

}
