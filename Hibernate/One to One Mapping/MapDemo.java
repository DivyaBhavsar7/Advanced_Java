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
		q1.setAnswer(a1); //for one to one
		
		Question q2=new Question();
		q2.setQuetionId(242);
		q2.setQuestion("What is collection framework?");
		
		Answer a2=new Answer();
		a2.setAnswerId(344);
		a2.setAnswer("API to work with objects in java.");
		a2.setQuestion(q2);
		q2.setAnswer(a2); //for one to one
		
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//one to one mapping
		s.save(q1);
		s.save(q2);
		s.save(a1);
		s.save(a2);
		
		tx.commit();
    
		//for one to one mapping
    //Fetching Data with get() method
		Question q=s.get(Question.class, 242);
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}
}
