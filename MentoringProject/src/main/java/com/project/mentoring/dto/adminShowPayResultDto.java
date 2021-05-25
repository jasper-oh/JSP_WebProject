package com.project.mentoring.dto;

import java.sql.Timestamp;

public class adminShowPayResultDto {
	
	String paymentPk;
	String senderName;
	String receiverName;
	int totalPrice;
	Timestamp payDate;
	Timestamp cancelDate;
	
	
	public adminShowPayResultDto() {
		super();
	}
	
	public adminShowPayResultDto(String paymentPk, String senderName, String receiverName, int totalPrice,
			Timestamp payDate, Timestamp cancelDate) {
		super();
		this.paymentPk = paymentPk;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.totalPrice = totalPrice;
		this.payDate = payDate;
		this.cancelDate = cancelDate;
	}

	public String getPaymentPk() {
		return paymentPk;
	}

	public void setPaymentPk(String paymentPk) {
		this.paymentPk = paymentPk;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getPayDate() {
		return payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	public Timestamp getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Timestamp cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	
	
	
	
	
	
	

}
