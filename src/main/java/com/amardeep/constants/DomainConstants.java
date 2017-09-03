package com.amardeep.constants;

public class DomainConstants {
	
	private DomainConstants(){
		throw new RuntimeException();
	}
	public static final String STUDENTS_BY_GPA="SELECT s FROM Student s where s.gpa = :gpa";
	public static final String STUDENTS_BY_COURSE="SELECT s FROM Student s where s.course IN :courseList";
}
