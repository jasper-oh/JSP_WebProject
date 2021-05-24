package com.project.mentoring.dao;

import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

public class MentorMentoringCompleteTokenCheckDao {
	DataSource dataSource;
	
	public MentorMentoringCompleteTokenCheckDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public int checkToken(String token) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int schedulePk = 0;
		try {
			connection = dataSource.getConnection();
			String tokenCheckQuery = "select schedule_schedulepk from payment where paymenttoken = ?";
			preparedStatement = connection.prepareStatement(tokenCheckQuery);
			
			preparedStatement.setString(1, token);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				schedulePk = resultSet.getInt("schedule_schedulepk");
				return schedulePk;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return schedulePk;
		
	}


	public void updateSendDate(int scheduledPk , String token) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String updateSendDateQuery = "update payment set paymentsenddate = now() where schedule_schedulepk = ? and paymenttoken= '"+token+"'";
			preparedStatement = connection.prepareStatement(updateSendDateQuery);
			
			preparedStatement.setInt(1, scheduledPk);
			preparedStatement.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();	
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
