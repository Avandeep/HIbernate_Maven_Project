package com.hibernate.map.m2o_o2m;

import javax.persistence.*;

@Entity(name="Answer_m2o_o2m")
public class Answer_m2o_o2m {
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private Question_m2o_o2m question;

	public Answer_m2o_o2m() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer_m2o_o2m(int answerId, String answer, Question_m2o_o2m question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question_m2o_o2m getQuestion() {
		return question;
	}

	public void setQuestion(Question_m2o_o2m question) {
		this.question = question;
	}
	
	
	

}
