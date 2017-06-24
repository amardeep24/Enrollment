package com.amardeep.dto;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.amardeep.model.Course;
import com.amardeep.utils.AppUtils;

public class CoursePayload extends BasePayload {
	
	private String name;
	private Set<StudentPayload> students;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<StudentPayload> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentPayload> students) {
		this.students = students;
	}
	public Course getCourseEntity(CoursePayload payload){
		Course course=new Course();
		AppUtils.getMapper().map(payload,course);
		return course;
	}

}
