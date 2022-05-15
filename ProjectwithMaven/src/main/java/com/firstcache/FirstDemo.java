package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstDemo {

	private static Student student;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=factory.openSession();
		
		Student stu1= s.get(Student.class,120);
		System.out.println(stu1);
		
		
		Student stu2= s.get(Student.class,120);
		System.out.println(stu2);
		
		System.out.println(s.contains(stu1));
		
		s.close();
		
		//System.out.println(s.contains(stu1));
	}

}
