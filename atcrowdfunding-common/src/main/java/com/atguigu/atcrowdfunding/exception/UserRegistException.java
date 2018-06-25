package com.atguigu.atcrowdfunding.exception;

public class UserRegistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5789149561987963476L;
	
	public UserRegistException() {
		
	}
	
	public UserRegistException(String message) {
		super(message);
	}

}
