package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.AdminQnaDto;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.dao;
 */

public class AdminQnaDao {
	DataSource dataSource;
	public AdminQnaDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();  //server context.xml연결
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 1. MethodName        : AdminQnAList
	 * 2. ClassName         : AdminQnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 3:49:00
	 * @return ArrayList<AdminQnaDto>
	 * @param button
	 * @return
	 */
	public ArrayList<AdminQnaDto> AdminQnAList(String button) {
		System.out.println(button);
		ArrayList<AdminQnaDto> dtos = new ArrayList<AdminQnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select * from question as q "
					+ "inner join user as u on u.userpk = q.user_userpk ";
			//+ "where q.outdate is null";
			switch (button) {
			case "Block":
				query = query+"where not q.outdate is null";
				break;
			case "General":
				query = query+"where q.outdate is null";
				break;
			case "All":
			default:
				break;
			}
			
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setInt(1, productpk);
			resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				int questionpk = resultSet.getInt("questionpk");
				String username = resultSet.getString("username");
				String questiontitle = resultSet.getString("questiontitle");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				AdminQnaDto dto = new AdminQnaDto(questionpk, username, questiontitle, indate, outdate);
				dtos.add(dto);
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
		return dtos;
		}
}
