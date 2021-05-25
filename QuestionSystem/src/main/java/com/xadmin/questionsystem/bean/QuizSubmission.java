package com.xadmin.questionsystem.bean;

import java.util.*;

public class QuizSubmission {
	int qsID;
	int quizID;
	int aid;
	Date startTime;
	Date endTime;
	int score;
	
	
	
	
	
	public QuizSubmission(int qsID, int quizID, int aid, Date startTime, Date endTime, int score) {
		super();
		this.qsID = qsID;
		this.quizID = quizID;
		this.aid = aid;
		this.startTime = startTime;
		this.endTime = endTime;
		this.score = score;
	}
	
	
	public int getQsID() {
		return qsID;
	}
	public void setQsID(int qsID) {
		this.qsID = qsID;
	}
	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	

}
