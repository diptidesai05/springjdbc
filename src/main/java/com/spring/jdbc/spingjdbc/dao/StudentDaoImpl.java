package com.spring.jdbc.spingjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.spingjdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public int insert(Student student) {
		
		String query="insert into Student(id,name,city) values(?,?,?)";
    	//fire query
    	int result =jdbctemplate.update(query,student.getId(),student.getName(),student.getCity());
    	System.out.println("No of records added "+result);
    	
		return result;
	}

	@Override
	public int update(Student student) {
	
		String query="update Student set name=? , city=? where id=?";
    	//fire query
    	int result =jdbctemplate.update(query,student.getName(),student.getCity(),student.getId());
    	System.out.println("No of records updated "+result);	
		return result;
	
	}

	@Override
	public int delete(Student student) {
		String query="delete from Student where id=?";
    	//fire query
    	int result =jdbctemplate.update(query,student.getId());
    	System.out.println("No of records deleted "+result);	
		return result;
	}

	@Override
	public Student getStudent(int studentId) {
      String query="select * from Student where id= ?";
      RowMapper<Student> rowMapper= new RowMapperImpl();
      Student student=this.jdbctemplate.queryForObject(query, rowMapper, studentId);
	  return student;
	}

	@Override
	public List<Student> getAllStudents() {

	    String query="select * from Student";
	    RowMapper<Student> rowMapper= new RowMapperImpl();
	    List<Student> student=this.jdbctemplate.query(query, rowMapper);
		return student;
	}
	
	

}
