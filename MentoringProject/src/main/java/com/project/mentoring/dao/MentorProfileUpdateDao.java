package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MentorProfileUpdateDao {
	DataSource dataSource;
	
	public MentorProfileUpdateDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public int mentorProfileUpdate(int userPk,String mentorImage, String userEmail ,String userPhone, String mentorAddress) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String mentorInfoUpdateQuery1 = "update mentor as m inner join user as mentoruser on m.user_userpk = mentoruser.userpk ";
			String mentorInfoUpdateQuery2 = "set m.mentorimage = '" + mentorImage + "'";
			String mentorInfoUpdateQuery3 = " , mentoruser.userphone = '"+ userPhone + "'";
			String mentorInfoUpdateQuery4 = " , mentoruser.useremail = '"+userEmail + "'";
			String mentorInfoUpdateQuery5 = " , m.mentoraddress = '"+mentorAddress+"'";
			String mentorInfoUpdateQuery6 = " where mentoruser.userpk = ?";
			System.out.println(mentorInfoUpdateQuery1 + mentorInfoUpdateQuery2 +mentorInfoUpdateQuery3 + mentorInfoUpdateQuery4 + mentorInfoUpdateQuery5 + mentorInfoUpdateQuery6);
			preparedStatement = connection.prepareStatement(mentorInfoUpdateQuery1 + mentorInfoUpdateQuery2 +mentorInfoUpdateQuery3 + mentorInfoUpdateQuery4 + mentorInfoUpdateQuery5 + mentorInfoUpdateQuery6);
						
			preparedStatement.setInt(1, userPk);
			
			preparedStatement.executeUpdate();
			
			return 1;
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return 0;
	}
	
	
	

}
