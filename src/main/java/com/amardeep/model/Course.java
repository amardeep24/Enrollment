package com.amardeep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="COURSE")
public class Course implements BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="courseSeq")
	@SequenceGenerator(sequenceName="COURSE_ID_SEQ", name = "courseSeq")
	@Column(name="COURSE_ID")
	private long id;
	
	@Column(name="COURSE_NAME") 
	private String name;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	@JsonBackReference
	private Student students;

	@Override
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	
}
