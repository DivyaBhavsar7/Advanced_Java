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
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answer;

	

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
	//for one to many mapping

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Question(int quetionId, String question, List<Answer> answer) {
		super();
		this.quetionId = quetionId;
		this.question = question;
		this.answer = answer;
	}
}
