package com.amardeep.service;

import com.amardeep.model.Student;

public interface StudentService {

	public Student getStudent(long id);
	
	public Student createStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(long id);
}
