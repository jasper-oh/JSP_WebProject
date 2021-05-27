package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.QnaDto;
import com.project.mentoring.dto.adminShowPayResultDto;

public class AdminShowPayResultDao {
	DataSource dataSource;
	public AdminShowPayResultDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();  //server context.xml연결
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<adminShowPayResultDto> adminPayResultList(int requestPage, int numOfTuplesPerPage){
		ArrayList<adminShowPayResultDto> adminShowPayResultDtos = new ArrayList<adminShowPayResultDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select py.paymentpk, menteeuser.username , mentoruser.username, s.totalprice , py.paymentpaydate, py.paymentcanceldate ";
			String query2 = "from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk ";
			String query3 = "inner join product as p on p.productpk = s.product_productpk ";
			String query4 = "inner join mentor as m on p.mentor_mentorpk = m.mentorpk ";
			String query5 = "inner join user as mentoruser on m.user_userpk = mentoruser.userpk ";
			String query6 = "inner join user as menteeuser on py.user_userpk = menteeuser.userpk limit ? , ? ";
			
			int offset = requestPage - 1;
			
			preparedStatement = connection.prepareStatement(query1 + query2 +query3 +query4 + query5 + query6);
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*numOfTuplesPerPage);
			}
			preparedStatement.setInt(2, numOfTuplesPerPage);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String paymentPk = resultSet.getString(1);
				String senderName = resultSet.getString(2);
				String RecieverName = resultSet.getString(3);
				int totalPrice = resultSet.getInt(4);
				Timestamp payDate = resultSet.getTimestamp(5);
				Timestamp cancelDate= resultSet.getTimestamp(6);
				
				adminShowPayResultDto dto = new adminShowPayResultDto(paymentPk, senderName, RecieverName, totalPrice, payDate, cancelDate);
				adminShowPayResultDtos.add(dto);
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
		
		
		
		return adminShowPayResultDtos;
	}
	
	
	public int countTuple() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		String query1 = "select count(*) ";
		String query2 = "from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk ";
		String query3 = "inner join product as p on p.productpk = s.product_productpk ";
		String query4 = "inner join mentor as m on p.mentor_mentorpk = m.mentorpk ";
		String query5 = "inner join user as mentoruser on m.user_userpk = mentoruser.userpk ";
		String query6 = "inner join user as menteeuser on py.user_userpk = menteeuser.userpk ";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query1 + query2 +query3 +query4+query5+query6);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				count = resultSet.getInt(1);
				
			}			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}


	public void cancelPayment(String paymentPk) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String query = "update payment set paymentcanceldate = now() where paymentpk = '"+paymentPk+"'";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
			e.printStackTrace();	
			}
		}
		
	}
	
	
}
