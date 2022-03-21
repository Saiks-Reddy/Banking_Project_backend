package com.lti.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao extends GenericDao{

	public boolean isCustomerPresent(String username) {
		return (Long) entityManager.createQuery("select count(c) from Customer c where c.username=: un")
				.setParameter("un", username).getSingleResult() == 1 ? true : false;
	}
	public boolean isValidUser(String username, String password) {
		return (Long) entityManager
				.createQuery("select count(c) from Customer c where c.username=: un and c.password =: pw")
				.setParameter("un", username).setParameter("pw", password).getSingleResult() == 1 ? true : false;

	}
	

}
