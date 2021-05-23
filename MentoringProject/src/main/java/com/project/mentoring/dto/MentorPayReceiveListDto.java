package com.project.mentoring.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class MentorPayReceiveListDto {
	
	
		String paymentPk;
		String producttitle;
		Date startday;
		int tatalprice;
		Timestamp paymentsenddate;

		
		public MentorPayReceiveListDto() {
			
		}


		public MentorPayReceiveListDto(String paymentPk, String producttitle, Date startday, int tatalprice,
				Timestamp paymentsenddate) {
			super();
			this.paymentPk = paymentPk;
			this.producttitle = producttitle;
			this.startday = startday;
			this.tatalprice = tatalprice;
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


		public int getTatalprice() {
			return tatalprice;
		}


		public void setTatalprice(int tatalprice) {
			this.tatalprice = tatalprice;
		}


		public Timestamp getPaymentsenddate() {
			return paymentsenddate;
		}


		public void setPaymentsenddate(Timestamp paymentsenddate) {
			this.paymentsenddate = paymentsenddate;
		}
		
		
	
	
}//
