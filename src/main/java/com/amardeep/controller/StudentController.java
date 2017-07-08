package com.amardeep.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amardeep.dto.StudentPayload;
import com.amardeep.model.Student;
import com.amardeep.service.StudentService;

@RestController
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService service;
	
	
	@GetMapping(value="student/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable("id") long id){
		logger.info("####getStudent invoked with id####"+id);
		return new ResponseEntity<Student>(service.getStudent(id),HttpStatus.OK);
		
	}
	@PostMapping(value="student/", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody StudentPayload studentPayload,UriComponentsBuilder builder){
		logger.info("####createStudent invoked ####");
		Student student=studentPayload.getStudentEntity(studentPayload);
		student=service.createStudent(student);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/student/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<Student>(student,headers,HttpStatus.CREATED);
	}
	@PutMapping(value="student/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody StudentPayload studentPayload){
		logger.info("####updateStudent invoked####");
		Student student=studentPayload.getStudentEntity(studentPayload);
		student.setId(id);
		service.updateStudent(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
	@DeleteMapping(value="student/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id){
		logger.info("####deleteStudent invoked with id####"+id);
		service.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
}
