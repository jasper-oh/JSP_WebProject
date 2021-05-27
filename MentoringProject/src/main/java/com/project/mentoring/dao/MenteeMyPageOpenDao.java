	package com.project.mentoring.dao;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.sql.DataSource;
import com.project.mentoring.dto.MenteeMyPageOpenDto;
	public class MenteeMyPageOpenDao {
		DataSource dataSource;
		public MenteeMyPageOpenDao() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public ArrayList<MenteeMyPageOpenDto> openMenteeMyPage(int userPk){
			System.out.println(1);
			ArrayList<MenteeMyPageOpenDto> menteeMyPageOpenDtos = new ArrayList<MenteeMyPageOpenDto>();
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet resultSet = null;
			try {
				connection = dataSource.getConnection();
				String query = "select userid, username, userphone, useremail from user where userpk = ?";
				// and py.paymentsenddate is null 과  and not py.paymentsenddate is null 
				prepareStatement = connection.prepareStatement(query);
				prepareStatement.setInt(1, userPk);  
				resultSet = prepareStatement.executeQuery();
				System.out.println("쿼리문 출력" + prepareStatement);
				while(resultSet.next()) {
					String userid = resultSet.getString("userid");
					String username = resultSet.getString("username");
					int userphone = resultSet.getInt("userphone");
					String useremail = resultSet.getString("useremail");
					MenteeMyPageOpenDto menteeMyPageOpenDto = new MenteeMyPageOpenDto(userid, username, userphone, useremail);
					menteeMyPageOpenDtos.add(menteeMyPageOpenDto);				
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
			return menteeMyPageOpenDtos;
		}
	}