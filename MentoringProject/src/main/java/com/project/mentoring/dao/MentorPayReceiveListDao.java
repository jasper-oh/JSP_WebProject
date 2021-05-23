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

public class MentorPayReceiveListDao {
	DataSource dataSource;
	public MentorPayReceiveListDao() {
		
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<MentorPayReceiveListDto> showPayReceiveList(int userPk){
		
		System.out.println(1);
		
		ArrayList<MentorPayReceiveListDto> mentorPayReceiveListDtos = new ArrayList<MentorPayReceiveListDto>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			System.out.println("쿼리문 시작");

			String query = "select py.paymentpk, p.title, s.startday, s.totalprice, py.paymentsenddate\n"
					+ "from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
					+ "inner join product as p on s.product_productpk = p.productpk\n"
					+ "inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
					+ "inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
					+ "inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
					+ "inner join major as mj on sb.major_majorpk = mj.majorpk\n"
					+ "where py.paymentcanceldate is null \n"
					+ "and not py.paymentsenddate is null \n"
					+ "and mentoruser.userpk = ?";

			// and py.paymentsenddate is null 과  and not py.paymentsenddate is null 
			
		System.out.println(2 + query);
			
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, userPk);  
			resultSet = prepareStatement.executeQuery();
			
			System.out.println("쿼리문 출력" + prepareStatement);
			
			while(resultSet.next()) {
				
				String paymentpk = resultSet.getString("paymentpk");
				String title = resultSet.getString("title");
				Date startday = resultSet.getDate("startday");
				int totalprice = resultSet.getInt("totalprice");
				Timestamp paymentsenddate = resultSet.getTimestamp("paymentsenddate");

				
				

				MentorPayReceiveListDto mentorPayReceiveListDto = new MentorPayReceiveListDto(paymentpk, title, startday, totalprice, paymentsenddate);
				mentorPayReceiveListDtos.add(mentorPayReceiveListDto);				
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
		
		return mentorPayReceiveListDtos;
	}
	
	
	
	
}
