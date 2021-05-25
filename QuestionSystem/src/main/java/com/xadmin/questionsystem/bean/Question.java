package com.xadmin.questionsystem.bean;

public class Question {
	private int id;
	private String questionText;
	private int cid;
	
	
	
	
	public Question(int id, String questionText, int cid) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.cid = cid;
	}
	
	
	
	public Question(String questionText, int cid) {
		super();
		this.questionText = questionText;
		this.cid = cid;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	

}
