package com.amardeep.service.business;

public class StudentException extends RuntimeException {

	private static final long serialVersionUID = 2340927561496377279L;
	
	private final String message;
	
	public StudentException(String message){
		super(message);
		this.message=message;
	}
	public StudentException(String message,Throwable throwable){
		super(message,throwable);
		this.message=message;
	}
	
	public String toString(){
		return this.getMessage();
	}
	

}
