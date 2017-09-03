package com.amardeep.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.amardeep.model.Student;
import com.amardeep.repository.StudentRepository;
import com.amardeep.service.impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
public class EnrollmentServiceImplUnitTest {
	
	@InjectMocks
	private StudentServiceImpl studentService;
	@Mock
	StudentRepository studentRepository;
	
	@Before
	public void setMock(){
		MockitoAnnotations.initMocks(this);
		
	}
	@Test
	public void testService(){
		//setting dummy data
		Student student=new Student();
		List<Student> studentList=new ArrayList<>();
		
		student.setName("Amardeep");
		student.setId(100L);
		studentList.add(student);
		
		//Creating method stubs
		when(studentRepository.findStudentsByGpa(2.0)).thenReturn(studentList);
		studentList=studentService.findStudentsByGpa(2.0);
		//Asserting 
		assertEquals("Amardeep",studentList.get(0).getName());
	}
}
