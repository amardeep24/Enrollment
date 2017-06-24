package com.amardeep.constants;

public enum AppConstants {
	STUDENT_CREATED("Student is created."),
	STUDENT_DELETED("Student is deleted."),
	STUDENT_UPDATED("Student is updated."), 
	STUDENT_DOESNOT_EXIST("Student does not exist."),
	STUDENT_NOT_CREATED("Student cannot be created.");
	
	private final String message;
	AppConstants(String message){
		this.message=message;
	}
	public String toString(){
		return this.message;
	}
	
}
