package com.yidi.entity;

public class UpperQuestion {
	String id;
	String question;
	String answer;
	String returnparameter;
	public UpperQuestion(String id,String question) {
		this.id=id;
		this.question=question;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the returnparameter
	 */
	public String getReturnparameter() {
		return returnparameter;
	}
	/**
	 * @param returnparameter the returnparameter to set
	 */
	public void setReturnparameter(String returnparameter) {
		this.returnparameter = returnparameter;
	}

}
