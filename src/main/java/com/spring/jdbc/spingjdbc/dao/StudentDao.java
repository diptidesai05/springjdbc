package com.spring.jdbc.spingjdbc.dao;

import java.util.List;

import com.spring.jdbc.spingjdbc.entites.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public int update(Student student);
	public int delete(Student student);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();

}
