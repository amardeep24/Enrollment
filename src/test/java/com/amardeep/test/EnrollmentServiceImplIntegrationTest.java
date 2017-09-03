package com.amardeep.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amardeep.Enrollment;
import com.amardeep.model.Student;
import com.amardeep.repository.StudentRepository;
import com.amardeep.service.impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Enrollment.class)
@Transactional
public class EnrollmentServiceImplIntegrationTest {
	
	@Autowired
	@Spy
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	@Before
	public void setMock(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateStudent(){
		Student student=new Student();
		student.setGpa(3.5);
		student.setName("Amardeep");
		
		Student studentResponse=studentService.createStudent(student);
		assertNotNull(studentResponse);
		assertEquals(studentResponse.getName(), "Amardeep");
		
		testGetStudent(studentResponse.getId());
		
		testUpdateStudent(studentResponse.getId());
		
		testDeleteStudent(studentResponse.getId());
		
	}
	private void testGetStudent(long id){
		Student studentResponse=studentService.getStudent(id);
		assertNotNull(studentResponse);
		assertEquals(studentResponse.getName(), "Amardeep");
	}
	private void testUpdateStudent(long id){
		Student studentResponse=studentService.getStudent(id);
		studentResponse.setName("Amardeep Bhowmick");
		studentService.updateStudent(studentResponse);
	}
	private void testDeleteStudent(long id){
		studentService.deleteStudent(id);
	}

}
