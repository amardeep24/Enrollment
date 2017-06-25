package com.amardeep.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amardeep.controller.StudentController;
import com.amardeep.model.Student;
import com.amardeep.repository.StudentRepository;
import com.amardeep.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student getStudent(long id) {
		return studentRepository.getEntity(id);
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.createEntity(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.updateEntity(student);
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteEntity(id);
	}

}
