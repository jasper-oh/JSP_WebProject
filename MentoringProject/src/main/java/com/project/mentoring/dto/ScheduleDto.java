package com.project.mentoring.dto;

import java.sql.Date;

public class ScheduleDto {
	int schedulepk;
	Date startday;
	int starttime;
	int endtime;
	int totalprice;
	
	public ScheduleDto(int schedulepk, Date startday, int starttime, int endtime, int totalprice) {
		super();
		this.schedulepk = schedulepk;
		this.startday = startday;
		this.starttime = starttime;
		this.endtime = endtime;
		this.totalprice = totalprice;
	}
	
	public int getSchedulepk() {
		return schedulepk;
	}
	public void setSchedulepk(int schedulepk) {
		this.schedulepk = schedulepk;
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
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
}