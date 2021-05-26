package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminMajorListDto;
import com.project.mentoring.dto.AdminUserListDto;

public class AdminMajorListDao {
	DataSource dataSource;
	
	public AdminMajorListDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	public ArrayList<AdminMajorListDto> majorList(){
		ArrayList<AdminMajorListDto> adminMajorListDtos = new ArrayList<AdminMajorListDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String majorListQuery = "select majorpk, majorname from major order by majorpk";
			prepareStatement = connection.prepareStatement(majorListQuery);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String majorPk = resultSet.getString("majorpk");
				String majorName = resultSet.getString("majorname");
				
				
				AdminMajorListDto adminMajorListDto = new AdminMajorListDto(majorPk,majorName);
				adminMajorListDtos.add(adminMajorListDto);				
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
		
		
		
		return adminMajorListDtos;
	}
	
	
	
	public int adminMajorInsert(String majorName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String adminMajorInsertQuery = "insert into major (majorname) values ( ? )";
			preparedStatement = connection.prepareStatement(adminMajorInsertQuery);
			
			preparedStatement.setString(1, majorName);
			
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
	/**
	 * 
	 * 1. MethodName        : AdminMajorUpdateView
	 * 2. ClassName         : AdminMajorListDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 24. 오전 1:49:47
	 * @return AdminMajorListDto
	 * @param imajorpk
	 * @return
	 */
	public AdminMajorListDto AdminMajorUpdateView(int imajorpk) {
		AdminMajorListDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from major where majorpk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, imajorpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {

				String majorPk = resultSet.getString("majorpk");
				String majorName = resultSet.getString("majorname");
				
				
				dto = new AdminMajorListDto(majorPk,majorName);
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

		return dto;
		
	}
	/**
	 * 
	 * 1. MethodName        : adminMajorUpdateAction
	 * 2. ClassName         : AdminMajorListDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 24. 오전 2:09:13
	 * @return void
	 * @param majorpk
	 * @param majorName
	 */
	public int adminMajorUpdateAction(int majorpk, String majorName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 1;
		try {
			connection = dataSource.getConnection();
			
			String adminMajorInsertQuery = "Update major set majorname = ? where majorpk = ?";
			preparedStatement = connection.prepareStatement(adminMajorInsertQuery);
			
			preparedStatement.setString(1, majorName);
			preparedStatement.setInt(2, majorpk);
			
			preparedStatement.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}finally {
			
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();	
			}catch(Exception e) {
				e.printStackTrace();
				result = 0;
			}
			
		}
		return result;
	}
	
	
}
