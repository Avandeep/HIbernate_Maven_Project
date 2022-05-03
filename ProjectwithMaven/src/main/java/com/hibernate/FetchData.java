package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session=factory.openSession();
		
		Student student=(Student)session.load(Student.class, 100);
		//System.out.println(student);
		Student student1=(Student)session.load(Student.class, 100);
		//System.out.println(student1);
	//	Student student2=(Student)session.load(Student.class, 1001);
		//System.out.println(student2);
		
		Address add=(Address)session.get(Address.class, 1);
		System.out.println("1:"+add.getStreet()+","+"2:"+add.getCity());
		System.out.println(add);
		
		Address add2=(Address)session.get(Address.class, 1);
		System.out.println("1:"+add2.getStreet()+","+"2:"+add2.getCity());
		System.out.println(add2);
		
		//Address add3=(Address)session.get(Address.class, 101);
		//System.out.println("1:"+add3.getStreet()+","+"2:"+add3.getCity());
		//System.out.println(add3);
		
		session.close();
		factory.close();
	}

}
