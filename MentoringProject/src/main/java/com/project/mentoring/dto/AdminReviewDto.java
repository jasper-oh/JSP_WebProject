package com.project.mentoring.dto;

import java.sql.Date;

/**
 * 클래스설명 : Admin Review List에 사용하는 Dto
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.dto;
 */

public class AdminReviewDto {
	int reviewpk;
	String username;
	String title;
	String reviewtitle;
	String reviewtext;
	int reviewscore;
	Date indate;
	Date outdate;
	
	
	
	/**
	 * 
	 * 1. MethodName        : AdminReviewDto
	 * 2. ClassName         : AdminReviewDto
	 * 3. Commnet           : adminReviewList.jsp
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 2:01:09
	 * @param reviewpk
	 * @param username
	 * @param title
	 * @param reviewtitle
	 * @param reviewtext
	 * @param reviewscore
	 * @param indate
	 * @param outdate
	 */
	public AdminReviewDto(int reviewpk, String username, String title, String reviewtitle, String reviewtext,
			int reviewscore, Date indate, Date outdate) {
		super();
		this.reviewpk = reviewpk;
		this.username = username;
		this.title = title;
		this.reviewtitle = reviewtitle;
		this.reviewtext = reviewtext;
		this.reviewscore = reviewscore;
		this.indate = indate;
		this.outdate = outdate;
	}
	
	
	
	public int getReviewpk() {
		return reviewpk;
	}
	public void setReviewpk(int reviewpk) {
		this.reviewpk = reviewpk;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReviewtitle() {
		return reviewtitle;
	}
	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}
	public String getReviewtext() {
		return reviewtext;
	}
	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext;
	}
	public int getReviewscore() {
		return reviewscore;
	}
	public void setReviewscore(int reviewscore) {
		this.reviewscore = reviewscore;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
}
