package com.csi.hibernate.projects;

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

		SessionFactory factory = cfg.buildSessionFactory();

		Question question = new Question();

		question.setQuestionId(1212);
		question.setQuestion("What is java");

		Answer answer = new Answer();

		answer.setAnserId(33);
		answer.setAnswer("java is programming language");
		answer.setQuestion(question);

		Answer answer1 = new Answer();

		answer1.setAnserId(343);
		answer1.setAnswer("with the help of java we can create software");
		answer1.setQuestion(question);

		Answer answer2 = new Answer();

		answer2.setAnserId(363);
		answer2.setAnswer("Java has diffrent type of framework");
		answer2.setQuestion(question);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);

		question.setAnswer(list);

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(question);
		s.save(answer);

		Question q = (Question) s.get(Question.class, 1212);

		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());

		tx.commit();
		s.close();
		factory.close();

	}
}
