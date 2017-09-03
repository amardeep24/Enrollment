package com.amardeep.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.amardeep.constants.DomainConstants;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="STUDENT")
@NamedQueries({
	@NamedQuery(name="Student.findStudentsByGpa",query=DomainConstants.STUDENTS_BY_GPA)
})
public class Student implements BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="studentSeq")
	@SequenceGenerator(sequenceName="STUDENT_ID_SEQ", name = "studentSeq")
	@Column(name="STUDENT_ID")
	private Long id;
	
	@Column(name="STUDENT_NAME") 
	private String name;
	
	@Column(name="GPA") 
	private Double gpa;
	
	@OneToMany(mappedBy="students")
	@JsonManagedReference
	private Set<Course> courses;

	@Override
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

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
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	
}
