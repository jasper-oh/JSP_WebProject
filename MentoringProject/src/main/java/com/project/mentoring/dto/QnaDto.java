package com.project.mentoring.dto;

import java.sql.Timestamp;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.dto;
 */

public class QnaDto {
	int questionpk;
	String username;
	String questiontitle;
	String questiontext;
	String result;
	Timestamp indate;
	Timestamp outdate;
	
	/**
	 * 
	 * 1. MethodName        : AdminQnaDto
	 * 2. ClassName         : AdminQnaDto
	 * 3. Commnet           : adminAnswerUpdateView.jsp
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 9:49:23
	 * @param questionpk
	 * @param questiontitle
	 * @param indate
	 * @param outdate
	 */
	public QnaDto(int questionpk, String questiontitle, Timestamp indate, Timestamp outdate) {
		super();
		this.questionpk = questionpk;
		this.questiontitle = questiontitle;
		this.indate = indate;
		this.outdate = outdate;
	}
	/**
	 * 
	 * 1. MethodName        : AdminQnaDto
	 * 2. ClassName         : AdminQnaDto
	 * 3. Commnet           : adminQnaList.jsp, adminAnswerView.jsp_AnswerList, userQnaList.jsp
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 6:45:43
	 * @param questionpk
	 * @param username
	 * @param questiontitle
	 * @param indate
	 * @param outdate
	 */
	public QnaDto(int questionpk, String username, String questiontitle, Timestamp indate, Timestamp outdate) {
		super();
		this.questionpk = questionpk;
		this.username = username;
		this.questiontitle = questiontitle;
		this.indate = indate;
		this.outdate = outdate;
	}

/**
 * 
 * 1. MethodName        : QnaDto
 * 2. ClassName         : QnaDto
 * 3. Commnet           : admin qna list
 * 4. 작성자                       : biso
 * 5. 작성일                       : 2021. 5. 25. 오후 2:44:47
 * @param questionpk
 * @param username
 * @param questiontitle
 * @param indate
 * @param outdate
 * @param result
 */
	public QnaDto(int questionpk, String username, String questiontitle, Timestamp indate,
			Timestamp outdate, String result) {
		super();
		this.questionpk = questionpk;
		this.username = username;
		this.questiontitle = questiontitle;
		this.indate = indate;
		this.outdate = outdate;
		this.result = result;
	}
	public QnaDto(int questionpk, String username, String questiontitle, String questiontext, Timestamp indate,
			Timestamp outdate) {
		super();
		this.questionpk = questionpk;
		this.username = username;
		this.questiontitle = questiontitle;
		this.questiontext = questiontext;
		this.indate = indate;
		this.outdate = outdate;
	}


	public int getQuestionpk() {
		return questionpk;
	}


	public void setQuestionpk(int questionpk) {
		this.questionpk = questionpk;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getQuestiontitle() {
		return questiontitle;
	}


	public void setQuestiontitle(String questiontitle) {
		this.questiontitle = questiontitle;
	}


	public String getQuestiontext() {
		return questiontext;
	}


	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}


	public Timestamp getIndate() {
		return indate;
	}


	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}


	public Timestamp getOutdate() {
		return outdate;
	}


	public void setOutdate(Timestamp outdate) {
		this.outdate = outdate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

}