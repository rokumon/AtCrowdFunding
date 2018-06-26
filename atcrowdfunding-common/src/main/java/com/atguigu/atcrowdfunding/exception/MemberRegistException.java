package com.atguigu.atcrowdfunding.exception;

public class MemberRegistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7747435873523644391L;

	public MemberRegistException() {
		
	}
	
	public MemberRegistException(String message) {
		super(message);
	}

}
