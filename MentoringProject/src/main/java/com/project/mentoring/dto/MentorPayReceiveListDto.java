package com.project.mentoring.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class MentorPayReceiveListDto {
	String paymentPk;
	String producttitle;
	Date startday;
	int totalprice;
	Timestamp paymentsenddate;
	
	
	
	
	public MentorPayReceiveListDto() {
		super();
	}




	public MentorPayReceiveListDto(String paymentPk, String producttitle, Date startday, int totalprice,
			Timestamp paymentsenddate) {
		super();
		this.paymentPk = paymentPk;
		this.producttitle = producttitle;
		this.startday = startday;
		this.totalprice = totalprice;
		this.paymentsenddate = paymentsenddate;
	}




	public String getPaymentPk() {
		return paymentPk;
	}




	public void setPaymentPk(String paymentPk) {
		this.paymentPk = paymentPk;
	}




	public String getProducttitle() {
		return producttitle;
	}




	public void setProducttitle(String producttitle) {
		this.producttitle = producttitle;
	}




	public Date getStartday() {
		return startday;
	}




	public void setStartday(Date startday) {
		this.startday = startday;
	}




	public int getTotalprice() {
		return totalprice;
	}




	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}




	public Timestamp getPaymentsenddate() {
		return paymentsenddate;
	}




	public void setPaymentsenddate(Timestamp paymentsenddate) {
		this.paymentsenddate = paymentsenddate;
	}
	
	
	
	
}
