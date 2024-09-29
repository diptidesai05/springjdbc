package com.spring.jdbc.spingjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.spingjdbc.dao.StudentDao;
import com.spring.jdbc.spingjdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages="com.spring.jdbc.spingjdbc.dao")
public class JDBCConfig {

	@Bean("datasource")
	 //public DriverManagerDataSource getDataSource() {
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Dipti123@MYSQL");
		return ds;
	 }
	
	  @Bean("jdbctemplate")
	  public JdbcTemplate getJdbcTemplate() {
		  JdbcTemplate jdbcTemplate= new JdbcTemplate();
		  jdbcTemplate.setDataSource(getDataSource());
		  return jdbcTemplate;
	  }
	  
	 /* @Bean("studentDao")
	  public StudentDao getStudentDao() {
		  StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		  studentDaoImpl.setJdbctemplate(getJdbcTemplate());
		  return studentDaoImpl;
	  }*/
}
