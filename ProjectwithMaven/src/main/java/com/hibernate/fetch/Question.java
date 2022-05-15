package com.hibernate.fetch;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;

@Entity(name="Question_fetch")
public class Question {
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
	@OneToMany(mappedBy="question",fetch=FetchType.EAGER)
	private List<Answer> answers;
	
	public Question() {
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	
	
	

}
