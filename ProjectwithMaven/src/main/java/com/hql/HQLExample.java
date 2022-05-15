package com.hql;

import java.util.Arrays;
import java.util.List;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.Query;
import org.hibernate.query.*;

import com.hibernate.*;

public class HQLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		String query="from Student as s where s.city=:x and s.name=:n";
		Query q=s.createQuery(query);
		q.setParameter("x", "kota");
		q.setParameter("n", "avan kaur");
		
		List<Student> list=q.getResultList();
		
		for(Student studentlist:list)
		{
			System.out.println(studentlist.getName()+":"+studentlist.getCerti().getCourse());
		}
		
		Transaction tx=s.beginTransaction();
	//	Query q1=s.createQuery("delete from Student s where s.city=:c");
		//q1.setParameter("c", "kota");
		//int r=q1.executeUpdate();
		
		Query q2=s.createQuery("Update Student set city=:c where name=:n");
		q2.setParameter("c", "noida");
		q2.setParameter("n", "avan kaur");
		int r=q2.executeUpdate();
		System.out.println(r+" objects updated");
		tx.commit();
		
		Query q3=s.createQuery("select q.question, q.questionId, a.answer from Question_m2o_o2m as q INNER JOIN q.answers as a");
		List<Object[]> list3=q3.getResultList();
		for(Object[] arr:list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		
		s.close();
		sf.close();
	}

}
