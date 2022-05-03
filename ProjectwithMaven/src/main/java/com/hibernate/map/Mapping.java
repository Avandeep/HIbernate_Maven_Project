package com.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Question q1 = new Question();
		q1.setQuestionId(111);
		q1.setQuestion("java ?");
		

		Answer a1 = new Answer();
		a1.setAnswerId(112);
		a1.setAnswer("Programming Language");
		a1.setQuestion(q1);

		q1.setAnswer(a1);

		Question q2 = new Question();
		q2.setQuestionId(113);
		q2.setQuestion("collection ?");

		Answer a2 = new Answer();
		a2.setAnswerId(114);
		a2.setAnswer("group of objects");
		a2.setQuestion(q2);

		q2.setAnswer(a2);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(q1);
		session.save(q2);
		session.save(a1);
		session.save(a2);
		
		tx.commit();
		
		Question ques=session.get(Question.class, 111);
		System.out.println(ques.getQuestion());
		System.out.println(ques.getAnswer());
		System.out.println(ques.getAnswer().getAnswer());
		
		Answer ans=session.get(Answer.class, 114);
		System.out.println(ans.getAnswer());
		System.out.println(ans.getQuestion().getQuestion());
		
		
		session.close();
		
		factory.close();
	}

}
