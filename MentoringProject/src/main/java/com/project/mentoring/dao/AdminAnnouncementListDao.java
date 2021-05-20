package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminAnnouncementListDto;


public class AdminAnnouncementListDao {
	DataSource dataSource;

	public AdminAnnouncementListDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<AdminAnnouncementListDto> showAnnouncement(){
		ArrayList<AdminAnnouncementListDto > adminAnnouncementListDtos = new ArrayList<AdminAnnouncementListDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String announcementListQuery = "select * from notice where outdate is null";
			prepareStatement = connection.prepareStatement(announcementListQuery);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int noticePk = resultSet.getInt("noticepk");
				int adminPk = resultSet.getInt("admin_adminpk");
				String noticeTitle = resultSet.getString("noticetitle");
				String noticeText= resultSet.getString("noticetext");
				Timestamp inDate = resultSet.getTimestamp("indate");
				
				
				AdminAnnouncementListDto adminAnnouncementDto = new AdminAnnouncementListDto(noticePk, adminPk, noticeTitle, noticeText, inDate);
				adminAnnouncementListDtos.add(adminAnnouncementDto);				
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
		
		return adminAnnouncementListDtos;
	}
	
	
}
