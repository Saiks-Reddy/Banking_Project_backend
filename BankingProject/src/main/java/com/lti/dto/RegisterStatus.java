package com.lti.dto;

public class RegisterStatus {

	private boolean status;
	private String messageIfAny;
	private String registeredUserName;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessageIfAny() {
		return messageIfAny;
	}
	public void setMessageIfAny(String messageIfAny) {
		this.messageIfAny = messageIfAny;
	}
	public String getRegisteredUserName() {
		return registeredUserName;
	}
	public void setRegisteredUserName(String registeredUserName) {
		this.registeredUserName = registeredUserName;
	}
	
	
}
