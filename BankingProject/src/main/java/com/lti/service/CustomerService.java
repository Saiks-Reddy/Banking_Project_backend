package com.lti.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;
import com.lti.dto.Login;

@Component
@Transactional
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	private Object username;
	
	public String register ( Customer customer) {
		if (customerDao.isCustomerPresent(customer.getUserName()))
			throw new CustomerServiceException("Customer already registered");
		else {
			Customer updatedCustomer= (Customer)customerDao.save(customer);
			return ((Customer) updatedCustomer).getUserName();
		}
	}
	public Customer login(Login login) {
		try {
			boolean String = customerDao.isValidUser(login.getUserName(), login.getPassword());
			Customer customer= customerDao.fetchById(Customer.class, username);
			return customer;
		}catch(NoResultException e){
			throw new CustomerServiceException("Invalid Email/ Password");
		}
	}
	
	

	
}



