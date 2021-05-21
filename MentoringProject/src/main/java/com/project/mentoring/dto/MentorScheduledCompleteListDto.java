package com.project.mentoring.dto;

public class MentorScheduledCompleteListDto {
		
		int scheduledPk;
		String userName;
		String userPhone;
		String scheduledMajor;
		String scheduledSubMajor;
		String scheduledPrice;
		
		public MentorScheduledCompleteListDto() {
			super();
		}

		public MentorScheduledCompleteListDto(int scheduledPk, String userName, String userPhone, String scheduledMajor,
				String scheduledSubMajor, String scheduledPrice) {
			super();
			this.scheduledPk = scheduledPk;
			this.userName = userName;
			this.userPhone = userPhone;
			this.scheduledMajor = scheduledMajor;
			this.scheduledSubMajor = scheduledSubMajor;
			this.scheduledPrice = scheduledPrice;
		}

		public int getScheduledPk() {
			return scheduledPk;
		}

		public void setScheduledPk(int scheduledPk) {
			this.scheduledPk = scheduledPk;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPhone() {
			return userPhone;
		}

		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}

		public String getScheduledMajor() {
			return scheduledMajor;
		}

		public void setScheduledMajor(String scheduledMajor) {
			this.scheduledMajor = scheduledMajor;
		}

		public String getScheduledSubMajor() {
			return scheduledSubMajor;
		}

		public void setScheduledSubMajor(String scheduledSubMajor) {
			this.scheduledSubMajor = scheduledSubMajor;
		}

		public String getScheduledPrice() {
			return scheduledPrice;
		}

		public void setScheduledPrice(String scheduledPrice) {
			this.scheduledPrice = scheduledPrice;
		}



		
	}


