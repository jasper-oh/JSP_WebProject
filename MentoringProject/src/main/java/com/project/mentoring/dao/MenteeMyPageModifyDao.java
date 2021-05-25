package com.project.mentoring.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class MenteeMyPageModifyDao {
	DataSource dataSource;
	public MenteeMyPageModifyDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void MenteeMyPageModify(int userphone, String useremail, int userPk){
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update user set userphone = ?, useremail = ? where userpk = ?";
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, userphone);  
			prepareStatement.setString(2, useremail);  
			prepareStatement.setInt(3, userPk);  
			prepareStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}// -------------------------