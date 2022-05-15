package com.hibernate.map.m2o_o2m;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;

@Entity(name="Question_m2o_o2m")
public class Question_m2o_o2m {
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	private List<Answer_m2o_o2m> answers;
	
	public Question_m2o_o2m() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Answer_m2o_o2m> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer_m2o_o2m> answers) {
		this.answers = answers;
	}

	public Question_m2o_o2m(int questionId, String question, List<Answer_m2o_o2m> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	
	
	

}
