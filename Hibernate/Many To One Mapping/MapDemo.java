package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		Question q1=new Question();
		q1.setQuetionId(1212);
		q1.setQuestion("What is java?");
		
		Answer a1=new Answer();
		a1.setAnswerId(34 );
		a1.setAnswer("programming language");
		a1.setQuestion(q1);
		
		Answer a11=new Answer();
		a11.setAnswerId(363);
		a11.setAnswer("to create software");
		a11.setQuestion(q1);
		
		Answer a12=new Answer();
		a12.setAnswerId(343);
		a12.setAnswer("diffrent type of framework");
		a12.setQuestion(q1);
		
		List<Answer> list=new ArrayList<Answer>();
		
		list.add(a1);
		list.add(a11);
		list.add(a12);
		
		q1.setAnswer(list);

		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//many to one mapping
		s.save(q1);
		s.save(a1);
		s.save(a11);
		s.save(a12);
		
		tx.commit();

    //fetching the data using  get() method
		Question que=(Question)s.get(Question.class, 1212);
		System.out.println(que.getQuestion());
		for(Answer a : que.getAnswer())
			System.out.println(a.getAnswer());
	
		s.close();
		factory.close();
	}
}
