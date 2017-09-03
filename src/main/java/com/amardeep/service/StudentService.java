package com.amardeep.service;

import java.util.List;

import com.amardeep.model.Student;

public interface StudentService {

	public Student getStudent(long id);
	
	public List<Student> findStudentsByGpa(double gpa);
	
	public List<Student> findStudentsByCourse(List<String> courses);
	
	public Student createStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(long id);
}
