package com.project.mentoring.dao;

import javax.naming.Context;
import java.sql.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserSignUpDao {
	DataSource dataSource;
	
	public UserSignUpDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void userSignUp(String userId, String userPw, String userName, String userEmail,String userPhone ) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String userSignUpQuery = "insert into user (userid, userpw, username, useremail, userphone, indate , usercheck) values ( ? , ? , ? , ? , ? , now(), 0 )";
			preparedStatement = connection.prepareStatement(userSignUpQuery);
			
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPw);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, userEmail);
			preparedStatement.setString(5, userPhone);
			
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
	
}