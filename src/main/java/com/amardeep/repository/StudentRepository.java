package com.amardeep.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.amardeep.constants.DomainConstants;
import com.amardeep.model.Student;

@Repository
public class StudentRepository extends AbstractEntityRepository<Student>{
	
	private EntityManager em;
	
	public StudentRepository(){
		super(Student.class);
		em=getEntityManager();
		
	}
	public List<Student> findStudentsByGpa(double gpa){
		TypedQuery<Student> query=em.createNamedQuery("Student.findStudentsByGpa", Student.class);
		query.setParameter("gpa",gpa);
		return query.getResultList();
	}
	public List<Student> findStudentsByCourse(List<String> courseList){
		TypedQuery<Student> query=em.createQuery(DomainConstants.STUDENTS_BY_COURSE, Student.class);
		query.setParameter("courseList",courseList);
		return query.getResultList();
	}
	public List<Student> findRejectedStudents(){
		Query query=em.createNativeQuery(DomainConstants.STUDENTS_BY_COURSE);
		return query.getResultList();
	}
	
}
