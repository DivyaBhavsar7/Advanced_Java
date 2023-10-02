package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Question {

	@Id
	@Column(name="que_id")
	private int quetionId;
	private String question;
	@OneToOne
	@JoinColumn(name="answer_id")
	private Answer answer;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuetionId() {
		return quetionId;
	}

	public void setQuetionId(int quetionId) {
		this.quetionId = quetionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	//for one to one mapping
	  public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Question(int quetionId, String question, Answer answer) {
		super();
		this.quetionId = quetionId;
		this.question = question;
		this.answer = answer;
	}
	}
}
