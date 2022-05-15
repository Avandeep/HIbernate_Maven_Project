package com.hibernate;

import java.io.*;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Database stared");

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student st = new Student();
		st.setId(101);
		st.setName("Avan");
		st.setCity("Kota");
		
		Address add=new Address();
		add.setStreet("Kota");
		add.setCity("Rajasthan");
		add.setOpen(true);
		add.setAddedDate(new Date());
		add.setX(1234.45);
		
		FileInputStream fis=new FileInputStream("src/main/java/passport_photo.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		add.setImage(data);
		
		Session ss=sf.openSession();		
		Transaction tx=ss.beginTransaction();		
		ss.save(st);	
		ss.save(add);	
		tx.commit();		
		ss.close();
		
		System.out.println("data inserted successfully...");
		
		
	}
}
