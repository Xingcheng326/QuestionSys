package com.xadmin.questionsystem.bean;

public class QuizQuestion {
	int qqid;
	int questionID;
	int quizID;
	int user_selection;
	
	
	
	
	public QuizQuestion(int qqid, int questionID, int quizID, int user_selection) {
		super();
		this.qqid = qqid;
		this.questionID = questionID;
		this.quizID = quizID;
		this.user_selection = user_selection;
	}
	
	
	public int getQqid() {
		return qqid;
	}
	public void setQqid(int qqid) {
		this.qqid = qqid;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}
	public int getUser_selection() {
		return user_selection;
	}
	public void setUser_selection(int user_selection) {
		this.user_selection = user_selection;
	}
	
	
	
	

}
