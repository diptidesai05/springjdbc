package com.spring.jdbc.spingjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.spingjdbc.dao.StudentDao;
import com.spring.jdbc.spingjdbc.entites.Student;

public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    	//ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/spingjdbc/springjdbc_config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
    	StudentDao studentDao =context.getBean("studentDao", StudentDao.class);
		
		Student student = new Student(); 
		student.setId(789);
		student.setName("Uiol");
		student.setCity("lop");
		studentDao.insert(student); 
		
		
    	//Student student = new Student(); 
		//student.setId(789);
		//student.setName("pol");
		//student.setCity("asd");
    	
    	//int result=studentDao.delete(student);
    	//System.out.println("No of records deleted "+result);
    		
    	//Student student = studentDao.getStudent(123);
    	//System.out.println(student);
    	
    	//List<Student> student=studentDao.getAllStudents();
    	//for(Student stud:student)
       // System.out.println(stud);
    }
}
