package com.hibernate.fetch;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Question q1 = new Question();
		q1.setQuestionId(100);
		q1.setQuestion("java ?");
		

		Answer a1 = new Answer();
		a1.setAnswerId(101);
		a1.setAnswer("Programming Language");
		
		Answer a2 = new Answer();
		a2.setAnswerId(102);
		a2.setAnswer("Used to build software applications");
		
		Answer a3 = new Answer();
		a3.setAnswerId(103);
		a3.setAnswer("has oops concepts");
		
		List<Answer> list=new ArrayList<Answer>();
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
	session.save(a1);
	session.save(a2);
	session.save(a3);
		
		tx.commit();
		
		Question ques=session.get(Question.class, 111);
		System.out.println(ques.getQuestionId());
		System.out.println(ques.getQuestion());
		//System.out.println(ques.getAnswers().size());
		
	/*	for(Answer ans:ques.getAnswers())
		{
			System.out.println(ans.getAnswer());
		//	System.out.println(ans.getQuestion().getQuestion());
			
		}*/
		
	//	Answer ans=session.get(Answer.class, 112);
	//	System.out.println(ans.getQuestion().getQuestion());
		
		
		session.close();
		
		factory.close();
	}

}
