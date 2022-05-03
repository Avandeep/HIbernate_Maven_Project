package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embedded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
		Student student1=new Student();
		student1.setId(120);
		student1.setName("avan kaur");
		student1.setCity("kota");
		
		Certificate certi1=new Certificate();
		certi1.setCourse("java");
		certi1.setDuration("3 months");
		
		student1.setCerti(certi1);
		
		Student student2=new Student();
		student2.setId(121);
		student2.setName("avandeep kaur");
		student2.setCity("kota Rajasthan");
		
		Certificate certi2=new Certificate();
		certi2.setCourse("java full stack");
		certi2.setDuration("6 months");
		
		student2.setCerti(certi2);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
		factory.close();
		
	}

}
