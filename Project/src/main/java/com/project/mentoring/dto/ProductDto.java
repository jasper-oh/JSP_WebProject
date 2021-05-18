package com.project.mentoring.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ProductDto {
	String title;
	String majorname;
	String submajorname;
	String introduce;
	int productpk;
	int price;
	int mentor_mentorpk;
	//Date startday;
	public ProductDto(String title, String majorname, String submajorname, int productpk, int price) {
		super();
		this.title = title;
		this.majorname = majorname;
		this.submajorname = submajorname;
		this.productpk = productpk;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getProductpk() {
		return productpk;
	}
	public void setProductpk(int productpk) {
		this.productpk = productpk;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMentor_mentorpk() {
		return mentor_mentorpk;
	}
	public void setMentor_mentorpk(int mentor_mentorpk) {
		this.mentor_mentorpk = mentor_mentorpk;
	}
	
	
}
