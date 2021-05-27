package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminMajorListDto;
import com.project.mentoring.dto.AdminSubMajorListDto;

public class AdminSubMajorListDao {
	DataSource dataSource;
	
	public AdminSubMajorListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public ArrayList<AdminSubMajorListDto> subMajorList(int majorPk){
		ArrayList<AdminSubMajorListDto> adminSubMajorListDtos = new ArrayList<AdminSubMajorListDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String subMajorListQuery = "select submajorpk, submajorname from submajor where major_majorpk = ? order by submajorpk";
			prepareStatement = connection.prepareStatement(subMajorListQuery);
			
			prepareStatement.setInt(1, majorPk);
			
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String submajorPk = resultSet.getString("submajorpk");
				String submajorName = resultSet.getString("submajorname");
				
				
				AdminSubMajorListDto adminSubMajorListDto = new AdminSubMajorListDto(submajorPk, submajorName); 
				adminSubMajorListDtos.add(adminSubMajorListDto);				
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
		
		return adminSubMajorListDtos;
	}
	
	public int adminSubMajorInsert(int majorPk,String subMajorName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String adminSubMajorInsertQuery = "insert into submajor (major_majorpk , submajorname) values ( ? , ? )";
			preparedStatement = connection.prepareStatement(adminSubMajorInsertQuery );
			
			preparedStatement.setInt(1, majorPk);
			preparedStatement.setString(2, subMajorName);
			
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
	
	public ArrayList<AdminSubMajorListDto> subMajorList(String majorName){
		ArrayList<AdminSubMajorListDto> adminSubMajorListDtos = new ArrayList<AdminSubMajorListDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String subMajorListQuery = "select submajorname from submajor where major_majorpk = (select majorpk from major where majorname=?);";
			prepareStatement = connection.prepareStatement(subMajorListQuery);
			
			prepareStatement.setString(1, majorName);
			
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				
				String submajorName = resultSet.getString("submajorname");
				
				
				AdminSubMajorListDto adminSubMajorNameListDto = new AdminSubMajorListDto(submajorName); 
				adminSubMajorListDtos.add(adminSubMajorNameListDto);				
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
		
		return adminSubMajorListDtos;
		
	}
	/**
	 * 
	 * 1. MethodName        : adminSubMajorDeleteAction
	 * 2. ClassName         : AdminSubMajorListDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 24. 오전 2:20:13
	 * @return int
	 * @param submajorpk
	 * @return
	 */
	public int adminSubMajorDeleteAction(int submajorpk) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String adminSubMajorInsertQuery = "delete from submajor where submajorpk = ?";
			preparedStatement = connection.prepareStatement(adminSubMajorInsertQuery );
			
			preparedStatement.setInt(1, submajorpk);
			
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
	 * 2. ClassName         : AdminSubMajorListDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 24. 오전 2:22:18
	 * @return AdminSubMajorListDto
	 * @param isubmajorpk
	 * @return
	 */
		public AdminSubMajorListDto AdminMajorUpdateView(int isubmajorpk) {
			AdminSubMajorListDto dto = null;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "select * from submajor where submajorpk = ?";

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, isubmajorpk);
				resultSet = preparedStatement.executeQuery();

				if(resultSet.next()) {

					String submajorPk = resultSet.getString("submajorpk");
					String submajorName = resultSet.getString("submajorname");
					
					
					dto = new AdminSubMajorListDto(submajorPk,submajorName);
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
	 * 1. MethodName        : adminSubMajorUpdateAction
	 * 2. ClassName         : AdminSubMajorListDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 24. 오전 2:22:14
	 * @return void
	 * @param submajorpk
	 * @param submajorName
	 */
		public int adminSubMajorUpdateAction(int submajorpk, String submajorName) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			int result = 1;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "Update submajor set submajorname = ? where submajorpk = ?";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, submajorName);
				preparedStatement.setInt(2, submajorpk);
				
				preparedStatement.executeUpdate();
				result = 1;
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
	
	
}// -- end Line
