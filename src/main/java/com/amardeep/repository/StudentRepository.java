package com.amardeep.repository;

import org.springframework.stereotype.Repository;

import com.amardeep.model.Student;

@Repository
public class StudentRepository extends AbstractEntityRepository<Student>{
	StudentRepository(){
		super(Student.class);
	}
}
