package com.xadmin.questionsystem.bean;

public class Options {
	
	int optionID;
	String optionValue;
	boolean ifCorrect;
	int qid;

	public Options(int optionID, String optionValue, boolean ifCorrect, int qid) {
		super();
		this.optionID = optionID;
		this.optionValue = optionValue;
		this.ifCorrect = ifCorrect;
		this.qid = qid;
	}
	
	

	public Options(String optionValue, boolean ifCorrect, int qid) {
		super();
		this.optionValue = optionValue;
		this.ifCorrect = ifCorrect;
		this.qid = qid;
	}



	public int getOptionID() {
		return optionID;
	}

	public void setOptionID(int optionID) {
		this.optionID = optionID;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public boolean isIfCorrect() {
		return ifCorrect;
	}

	public void setIfCorrect(boolean ifCorrect) {
		this.ifCorrect = ifCorrect;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}
	
	

}
