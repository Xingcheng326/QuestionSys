package com.xadmin.questionsystem.bean;

public class Quiz {
	int quizID;
	int quizCid;
	String quizName;
	
	
	
	
	public Quiz(int quizID, int quizCid, String quizName) {
		super();
		this.quizID = quizID;
		this.quizCid = quizCid;
		this.quizName = quizName;
	}
	
	
	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}
	public int getQuizCid() {
		return quizCid;
	}
	public void setQuizCid(int quizCid) {
		this.quizCid = quizCid;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	

}
