package com.amardeep.dto;

import com.amardeep.model.Student;
import com.amardeep.utils.AppUtils;

public class StudentPayload extends BasePayload {
	private String name;
	private Double gpa;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public Student getStudentEntity(StudentPayload payload){
		Student student=new Student();
		AppUtils.getMapper().map(payload,student);
		student.setId(null);
		return student;
	}
	

}
