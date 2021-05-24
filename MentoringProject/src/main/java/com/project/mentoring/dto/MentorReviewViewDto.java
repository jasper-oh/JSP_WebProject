package com.project.mentoring.dto;
import java.sql.Timestamp;
	public class MentorReviewViewDto {
		String username;
		String title;
		String reviewtitle;
		String reviewtext;
		int reviewscore;
		Timestamp indate;
		int productpk;
		int reviewpk;
		public MentorReviewViewDto() {
			super();
		}
		public MentorReviewViewDto(String title, String reviewtitle, int reviewscore, Timestamp indate, int productpk) {
			super();
			this.title = title;
			this.reviewtitle = reviewtitle;
			this.reviewscore = reviewscore;
			this.indate = indate;
			this.productpk = productpk;
		}
		public MentorReviewViewDto(String username, String reviewtitle, String reviewtext, int reviewscore, Timestamp indate, int reviewpk) {
			super();
			this.username = username;
			this.reviewtitle = reviewtitle;
			this.reviewtext = reviewtext;
			this.reviewscore = reviewscore;
			this.indate = indate;
			this.reviewpk = reviewpk;
		}
		public int getProductpk() {
			return productpk;
		}
		public void setProductpk(int productpk) {
			this.productpk = productpk;
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
		public int getReviewscore() {
			return reviewscore;
		}
		public void setReviewscore(int reviewscore) {
			this.reviewscore = reviewscore;
		}
		public Timestamp getIndate() {
			return indate;
		}
		public void setIndate(Timestamp indate) {
			this.indate = indate;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getReviewpk() {
			return reviewpk;
		}
		public void setReviewpk(int reviewpk) {
			this.reviewpk = reviewpk;
		}
		public String getReviewtext() {
			return reviewtext;
		}
		public void setReviewtext(String reviewtext) {
			this.reviewtext = reviewtext;
		}
	}