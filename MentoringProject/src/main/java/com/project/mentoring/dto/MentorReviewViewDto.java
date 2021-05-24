package com.project.mentoring.dto;

import java.sql.Timestamp;
	public class MentorReviewViewDto {
		
		String title;
		String reviewtitle;
		int reviewscore;
		Timestamp indate;
		int productpk;
		
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

		
		
		
		
	}