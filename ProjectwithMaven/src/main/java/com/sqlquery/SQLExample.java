package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//import org.hibernate.cfg.Configuration;
import com.hibernate.*;

public class SQLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		Query query=s.createSQLQuery("select * from Student");
		
		
		
		List<Object[]> list=query.list();
		for(Object[] student:list)
		{
			System.out.println(student[0]+":"+student[1]+":"+student[2]);
			System.out.println(Arrays.toString(student));
			System.out.println(Arrays.deepToString(student));
		}
		
		s.close();
		sf.close();

	}

}
