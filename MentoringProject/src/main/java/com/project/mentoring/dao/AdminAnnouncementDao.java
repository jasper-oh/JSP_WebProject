package com.project.mentoring.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminAnnouncementDto;


import java.sql.*;
import java.util.ArrayList;

public class AdminAnnouncementDao {

	DataSource dataSource;

	public AdminAnnouncementDao() {
		
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	/* Help Page 에 notice의 list 를 
	 * 
	 *   글제목, 글내용, 작성날짜 보여주기 */
	public ArrayList<AdminAnnouncementDto > noticeList(){
		ArrayList<AdminAnnouncementDto> adminAnnouncementDtos = new ArrayList<AdminAnnouncementDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String noticeListQuery = "select noticePk, admin_adminpk, noticetitle, noticetext, indate , outdate from notice";
			prepareStatement = connection.prepareStatement(noticeListQuery);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String noticePk = resultSet.getString("noticePk");
				String admin_adminpk = resultSet.getString("admin_adminpk");
				String noticetitle = resultSet.getString("noticetitle");
				String noticetext = resultSet.getString("noticetext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
				
				AdminAnnouncementDto adminAnnouncementDto = new AdminAnnouncementDto(noticePk, admin_adminpk, noticetitle, noticetext, indate, outdate);
				adminAnnouncementDtos.add(adminAnnouncementDto);				
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
		
		return adminAnnouncementDtos;
	}


	public void write(String noticetitle, String noticetext) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into notice (noticetitle, noticetext, inDate) values (?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, noticetitle);
			preparedStatement.setString(2, noticetext);

			
			preparedStatement.executeUpdate();
			
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
		
	}
	
	public AdminAnnouncementDto adminAnnouncementContentView(String strID) {
		AdminAnnouncementDto adminAnnouncementDto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from notice where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				


				String noticePk = resultSet.getString("noticePk");
				String admin_adminpk = resultSet.getString("admin_adminpk");
				String noticetitle = resultSet.getString("noticetitle");
				String noticetext = resultSet.getString("noticetext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");

				
//				
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				adminAnnouncementDto = new AdminAnnouncementDto(noticePk, admin_adminpk, noticetitle, noticetext, indate, outdate);
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
		return adminAnnouncementDto;
	}



		

	
	public void modify(String noticepk, String admin_adminpk, String noticeTitle, String noticetext) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update notice set admin_adminpk = ?, noticeTitle = ?, noticetext = ?, inDate = now() where noticepk = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, admin_adminpk);
			preparedStatement.setString(2, noticeTitle);
			preparedStatement.setString(3, noticetext);
			preparedStatement.setString(4, noticepk);
			
			preparedStatement.executeUpdate();
			
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
	}
	
	public void delete(String noticepk) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from notice where noticepk = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, noticepk);
			
			preparedStatement.executeUpdate();
			
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
	}

	
	
	
	
}//--end Line

