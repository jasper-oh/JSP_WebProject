package com.project.mentoring.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class MenteeDto {
	
	String menteename;
	String majorname;
	String submajorname;
	Date startday;
	int starttime;
	int endtime;
	int paymentpk;
	String paymenttoken;
	Timestamp paymentcanceldate;
	Timestamp paymentpaydate;
	
	public MenteeDto(String menteename, String majorname, String submajorname, Date startday, int starttime,
			int endtime, int paymentpk, String paymenttoken, Timestamp paymentcanceldate, Timestamp paymentpaydate) {
		super();
		this.menteename = menteename;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.paymentpk = paymentpk;
		this.paymenttoken = paymenttoken;
		this.paymentcanceldate = paymentcanceldate;
		this.paymentpaydate = paymentpaydate;
	}


	public String getPaymenttoken() {
		return paymenttoken;
	}


	public void setPaymenttoken(String paymenttoken) {
		this.paymenttoken = paymenttoken;
	}


	public Timestamp getPaymentcanceldate() {
		return paymentcanceldate;
	}


	public void setPaymentcanceldate(Timestamp paymentcanceldate) {
		this.paymentcanceldate = paymentcanceldate;
	}


	public Timestamp getPaymentpaydate() {
		return paymentpaydate;
	}


	public void setPaymentpaydate(Timestamp paymentpaydate) {
		this.paymentpaydate = paymentpaydate;
	}


	public String getMenteename() {
		return menteename;
	}


	public void setMenteename(String menteename) {
		this.menteename = menteename;
	}


	public String getMajorname() {
		return majorname;
	}


	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}


	public String getSubmajorname() {
		return submajorname;
	}


	public void setSubmajorname(String submajorname) {
		this.submajorname = submajorname;
	}


	public Date getStartday() {
		return startday;
	}


	public void setStartday(Date startday) {
		this.startday = startday;
	}


	public int getStarttime() {
		return starttime;
	}


	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}


	public int getEndtime() {
		return endtime;
	}


	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}


	public int getPaymentpk() {
		return paymentpk;
	}


	public void setPaymentpk(int paymentpk) {
		this.paymentpk = paymentpk;
	}
	
	
	
	
}//-------------
