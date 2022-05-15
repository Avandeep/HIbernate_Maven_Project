package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//import org.hibernate.cfg.Configuration;
import com.hibernate.*;

public class HQLPegination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		Query query=s.createQuery("from Student");
		
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List<Student> list=query.list();
		for(Student student:list)
		{
			System.out.println(student.getId()+":"+student.getName()+":"+student.getCity());
		}
		
		s.close();
		sf.close();

	}

}
