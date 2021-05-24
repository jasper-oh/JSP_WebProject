package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.MentorPayReceiveListDto;
import com.project.mentoring.dto.MentorReviewViewDto;
import com.project.mentoring.dto.ShareVar;


public class MentorReviewViewDao {
	DataSource dataSource;

	public MentorReviewViewDao() {
		
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<MentorReviewViewDto> showReviewView(int userPk){
		
		System.out.println(1);
		
		ArrayList<MentorReviewViewDto> mentorReviewViewDtos = new ArrayList<MentorReviewViewDto>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			System.out.println("쿼리문 시작");

			String query = "select p.title, r.reviewtitle, r.reviewscore, r.indate, p.productpk\n"
					+ "from product as p inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
					+ "inner join user as mentoruser on mentoruser.userpk = m.user_userpk\n"
					+ "inner join review as r inner join user as mentee on r.user_userpk = mentee.userpk\n"
					+ "where mentoruser.userpk = ?;";

			// and py.paymentsenddate is null 과  and not py.paymentsenddate is null 
			
		System.out.println(2 + query);
			
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, userPk);  
			resultSet = prepareStatement.executeQuery();
			
			System.out.println("쿼리문 출력" + prepareStatement);
			
			while(resultSet.next()) {
				
				String title = resultSet.getString("title");
				String reviewtitle = resultSet.getString("reviewtitle");
				int reviewscore = resultSet.getInt("reviewscore");
				Timestamp indate = resultSet.getTimestamp("indate");
				int productpk = resultSet.getInt("productpk");

				
				

				MentorReviewViewDto mentorReviewViewDto = new MentorReviewViewDto(title, reviewtitle, reviewscore, indate, productpk);
				mentorReviewViewDtos.add(mentorReviewViewDto);				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println(3);
		
		return mentorReviewViewDtos;
	}

	public ArrayList<MentorReviewViewDto> ProductReviewList(int userPk){
		ArrayList<MentorReviewViewDto> mentorReviewViewDtos = new ArrayList<MentorReviewViewDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select mentee.username, r.reviewtitle, r.reviewtext, r.reviewscore, r.indate, r.reviewpk\n"
					+ "from product as p inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
					+ "inner join user as mentoruser on mentoruser.userpk = m.user_userpk\n"
					+ "inner join review as r inner join user as mentee on r.user_userpk = mentee.userpk\n"
					+ "where r.outdate is null and mentoruser.userpk = ? and p.productpk = ? ";
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, userPk);
			prepareStatement.setInt(2, ShareVar.productpk);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				String username = resultSet.getString("username");
				String reviewtitle = resultSet.getString("reviewtitle");
				String reviewtext = resultSet.getString("reviewtext");
				int reviewscore = resultSet.getInt("reviewscore");
				Timestamp indate = resultSet.getTimestamp("indate");
				int reviewpk = resultSet.getInt("reviewpk");
				MentorReviewViewDto mentorReviewViewDto = new MentorReviewViewDto(username, reviewtitle, reviewtext, reviewscore, indate, reviewpk);
				mentorReviewViewDtos.add(mentorReviewViewDto);				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mentorReviewViewDtos;
}
}	
