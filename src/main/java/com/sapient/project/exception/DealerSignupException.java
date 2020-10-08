package com.sapient.project.exception;

public class DealerSignupException extends Exception{	
	private static final long serialVersionUID = 1L;
	
	public DealerSignupException() {
		super();
	}
	
	public DealerSignupException(String message) {
		super(message);
	}
	
	public DealerSignupException(String message,Throwable e) {
		super(message);
	}

	@Override
	public String getMessage() {		
		return super.getMessage();
	}
	
	

}
