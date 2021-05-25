package com.project.mentoring.dto;
public class MenteeMyPageOpenDto {
	String userid;
	String username;
	int userphone;
	String useremail;
	public MenteeMyPageOpenDto() {
		super();
	}
	public MenteeMyPageOpenDto(String userid, String username, int userphone, String useremail) {
		super();
		this.userid = userid;
		this.username = username;
		this.userphone = userphone;
		this.useremail = useremail;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserphone() {
		return userphone;
	}
	public void setUserphone(int userphone) {
		this.userphone = userphone;
	}
	public String getuseremail() {
		return useremail;
	}
	public void setuseremail(String useremail) {
		this.useremail = useremail;
	}
}