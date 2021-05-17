package com.project.mentoring.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Part;
import javax.sql.*;

import com.project.mentoring.dto.AdminSubMajorListDto;

public class MentorProfileDao {
	
	DataSource dataSource;
	
	public MentorProfileDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int mentorProfileInsert(String mentorbirth,String mentorgender, String mentoraddress,String mentorimage){ 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		
		try {
			connection = dataSource.getConnection();
			
			String mentorProfileQuery = "insert into mentor (user_userpk ,mentorimage, mentoraddress, mentorgender, mentorbirth,indate) value (? , ? , ? , ? , ? , now() )";
			preparedStatement = connection.prepareStatement(mentorProfileQuery);
			
			
			
			preparedStatement.setString(1,UserLoginDao.userPk);
			preparedStatement.setString(2, mentorimage);
			preparedStatement.setString(3, mentoraddress);
			preparedStatement.setString(4, mentorgender);
			preparedStatement.setString(5, mentorbirth);
			
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
	
	public int mentorProfileIntroduceInsert(int mentorPk,int subMajorPk, String title,String introduce,String price) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			
			String mentorProfileIntroduceQuery = "insert into product (mentor_mentorpk, submajor_submajorpk,title,introduce,price) values ( ? , ? , ? , ? , ? )";
			preparedStatement = connection.prepareStatement(mentorProfileIntroduceQuery);
			
			preparedStatement.setInt(1, mentorPk);
			preparedStatement.setInt(2, subMajorPk);
			preparedStatement.setString(3, title);
			preparedStatement.setString(4, introduce);
			preparedStatement.setString(5, price);
			

			preparedStatement.executeUpdate();
			
			return 1;
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

		return 0;
	}
	
	
	public int mentorProfileMajorInsert(String major,String submajor) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String mentorProfileMajorQuery = "";
			preparedStatement = connection.prepareStatement(mentorProfileMajorQuery);
			
			
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
	
	public int getMentorPk(int userPk) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int mentorPk = 0 ;
		try {
			connection = dataSource.getConnection();
			
			String getMentorPkQuery = "select mentorpk from mentor where user_userPk = ? ";
			preparedStatement = connection.prepareStatement(getMentorPkQuery);
			
			preparedStatement.setInt(1, userPk);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String strMentorPk = resultSet.getString("mentorpk");
				
				mentorPk = Integer.parseInt(strMentorPk);
				
				return mentorPk;
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
		
		return mentorPk;
		
	}
	

}//-end Line
