package com.csi.hibernate.projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import antlr.collections.List;

@Entity
public class Question {
	@Id
	@Column(name = "question_Id")
	private int questionId;
	private String question;
	
	@OneToMany
	private java.util.List<Answer>  answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String question, java.util.List<Answer> answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public java.util.List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(java.util.List<Answer> answer) {
		this.answer = answer;
	}

	

}
