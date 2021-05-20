package com.project.mentoring.dto;

import java.sql.Timestamp;

public class AdminAnnouncementListDto {
	
	int noticePk;
	int adminPk;
	String noticeTitle;
	String noticeText;
	Timestamp inDate;
	
	public AdminAnnouncementListDto() {
		
	}
	public AdminAnnouncementListDto(int noticePk, int adminPk, String noticeTitle, String noticeText, Timestamp inDate) {
		super();
		this.noticePk = noticePk;
		this.adminPk = adminPk;
		this.noticeTitle = noticeTitle;
		this.noticeText = noticeText;
		this.inDate = inDate;
	}
	public int getNoticePk() {
		return noticePk;
	}
	public void setNoticePk(int noticePk) {
		this.noticePk = noticePk;
	}
	public int getAdminPk() {
		return adminPk;
	}
	public void setAdminPk(int adminPk) {
		this.adminPk = adminPk;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeText() {
		return noticeText;
	}
	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}
	public Timestamp getInDate() {
		return inDate;
	}
	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}
	
}
