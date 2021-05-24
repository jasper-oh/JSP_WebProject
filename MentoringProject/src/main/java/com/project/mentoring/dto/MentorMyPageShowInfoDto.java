package com.project.mentoring.dto;

public class MentorMyPageShowInfoDto {
	
	int userpk;
	int mentorpk;
	String userid;
	String useremail;
	String userphone;
	String mentorimage;
	String mentoraddress;
	
	
	
	
	public MentorMyPageShowInfoDto() {
		super();
	}




	public MentorMyPageShowInfoDto(int userpk, int mentorpk, String userid, String useremail, String userphone,
			String mentorimage, String mentoraddress) {
		super();
		this.userpk = userpk;
		this.mentorpk = mentorpk;
		this.userid = userid;
		this.useremail = useremail;
		this.userphone = userphone;
		this.mentorimage = mentorimage;
		this.mentoraddress = mentoraddress;
	}




	public int getUserpk() {
		return userpk;
	}




	public void setUserpk(int userpk) {
		this.userpk = userpk;
	}




	public int getMentorpk() {
		return mentorpk;
	}




	public void setMentorpk(int mentorpk) {
		this.mentorpk = mentorpk;
	}




	public String getUserid() {
		return userid;
	}




	public void setUserid(String userid) {
		this.userid = userid;
	}




	public String getUseremail() {
		return useremail;
	}




	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}




	public String getUserphone() {
		return userphone;
	}




	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}




	public String getMentorimage() {
		return mentorimage;
	}




	public void setMentorimage(String mentorimage) {
		this.mentorimage = mentorimage;
	}




	public String getMentoraddress() {
		return mentoraddress;
	}




	public void setMentoraddress(String mentoraddress) {
		this.mentoraddress = mentoraddress;
	}
	
	
	
	
}
