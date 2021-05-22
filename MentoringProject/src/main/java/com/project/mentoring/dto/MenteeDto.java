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
	String paymentpk;
	String paymenttoken;
	int totalprice;
	String reviewtitle;
	String productpk;
	String title;
	int reviewpk;
	String reviewText;
	int reviewscore;
	Timestamp paymentcanceldate;
	Timestamp paymentpaydate;
	String mentorname;
	
	public MenteeDto(String menteename, String majorname, String submajorname, Date startday, int starttime,
			int endtime, String paymentpk, String paymenttoken, Timestamp paymentcanceldate, Timestamp paymentpaydate) {
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
	public MenteeDto(String mentorname, String majorname, String title, String reviewtitle, String productpk,int reviewpk) {
		super();
		this.mentorname = mentorname;
		this.majorname = majorname;
		this.title = title;
		this.reviewtitle = reviewtitle;
		this.productpk = productpk;
		this.reviewpk = reviewpk;
	}

	public MenteeDto(String menteename, String majorname, String submajorname, Date startday, int starttime,
			int endtime, String paymentpk, int totalprice) {
		super();
		this.menteename = menteename;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.paymentpk = paymentpk;
		this.totalprice = totalprice;
	}
	
	public MenteeDto(String mentorname, String majorname, String submajorname, Date startday, int starttime,
			int endtime, int totalprice,String paymentpk) {
		super();
		this.mentorname = mentorname;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalprice = totalprice;
		this.paymentpk = paymentpk;
	}
	
	
	public MenteeDto(String menteename, String majorname, String submajorname, Date startday, int starttime,
			int endtime, String paymentpk, String paymenttoken) {
		super();
		this.menteename = menteename;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.paymentpk = paymentpk;
		this.paymenttoken = paymenttoken;
	}

	
	public MenteeDto(String paymentpk, String reviewtitle, String reviewText, int reviewscore) {
		super();
		this.paymentpk = paymentpk;
		this.reviewtitle = reviewtitle;
		this.reviewText = reviewText;
		this.reviewscore = reviewscore;
	}
	public String getMentorname() {
		return mentorname;
	}
	public void setMentorname(String mentorname) {
		this.mentorname = mentorname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getReviewtitle() {
		return reviewtitle;
	}
	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}
	public String getProductpk() {
		return productpk;
	}
	public void setProductpk(String productpk) {
		this.productpk = productpk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getPaymentpk() {
		return paymentpk;
	}
	public void setPaymentpk(String paymentpk) {
		this.paymentpk = paymentpk;
	}

	public int getReviewpk() {
		return reviewpk;
	}
	public void setReviewpk(int reviewpk) {
		this.reviewpk = reviewpk;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getReviewscore() {
		return reviewscore;
	}
	public void setReviewscore(int reviewscore) {
		this.reviewscore = reviewscore;
	}

	
	
	
}//-------------