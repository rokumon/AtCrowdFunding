package com.atguigu.atcrowdfunding.exception;

public class UserLoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7089462150845978772L;
	
	public UserLoginException() {
		
	}
	
	public UserLoginException(String message) {
		super(message);
	}
	
	

}
