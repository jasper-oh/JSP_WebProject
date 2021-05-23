package com.project.mentoring.dto;

import java.sql.Timestamp;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.dto;
 */

public class AdminQnaDto {
	int questionpk;
	String username;
	String questiontitle;
	Timestamp indate;
	Timestamp outdate;
	public AdminQnaDto(int questionpk, String username, String questiontitle, Timestamp indate, Timestamp outdate) {
		super();
		this.questionpk = questionpk;
		this.username = username;
		this.questiontitle = questiontitle;
		this.indate = indate;
		this.outdate = outdate;
	}
	public int getquestionpk() {
		return questionpk;
	}
	public void setquestionpk(int questionpk) {
		this.questionpk = questionpk;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getquestiontitle() {
		return questiontitle;
	}
	public void setquestiontitle(String questiontitle) {
		this.questiontitle = questiontitle;
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
	
	
	

}
