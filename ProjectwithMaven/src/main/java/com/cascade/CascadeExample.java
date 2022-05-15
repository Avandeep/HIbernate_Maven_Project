package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.map.m2o_o2m.Answer_m2o_o2m;
import com.hibernate.map.m2o_o2m.Question_m2o_o2m;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SessionFactory factory = new Configuration().configure("/com/hibernate/map/m2o_o2m/hibernate.cfg.xml").buildSessionFactory();
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Question_m2o_o2m q1 = new Question_m2o_o2m();
		q1.setQuestionId(18);
		q1.setQuestion("Spring ?");
		

		Answer_m2o_o2m a1 = new Answer_m2o_o2m();
		a1.setAnswerId(12);
		a1.setAnswer("Loosecoupling");
		
		Answer_m2o_o2m a2 = new Answer_m2o_o2m();
		a2.setAnswerId(13);
		a2.setAnswer("Spring Boot");
		
		Answer_m2o_o2m a3 = new Answer_m2o_o2m();
		a3.setAnswerId(14);
		a3.setAnswer("framework");
		
		List<Answer_m2o_o2m> list=new ArrayList<Answer_m2o_o2m>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		a1.setQuestion(q1);
		a2.setQuestion(q1);
		a3.setQuestion(q1);
		

		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
	session.save(q1);
	
		
		tx.commit();
		
		
		
		
		session.close();
		
		factory.close();
	}

}
