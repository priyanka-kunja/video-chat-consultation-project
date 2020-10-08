package com.sapient.project.exception;

public class DealerSigninException extends Exception{
	private static final long serialVersionUID = 1L;
	public DealerSigninException() {
		super();
	}
	
	public DealerSigninException(String message) {
		super(message);
	}
	
	public DealerSigninException(String message,Throwable e) {
		super(message);
	}

	@Override
	public String getMessage() {		
		return super.getMessage();
	}

}
