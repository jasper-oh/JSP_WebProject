package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.QnaDto;
import com.project.mentoring.dto.ShareVar;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.dao;
 */

public class QnaDao {
	DataSource dataSource;
	public QnaDao() {
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
	public ArrayList<QnaDto> AdminQnAList(int requestPage, int numOfTuplesPerPage) {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select q.questionpk, u.username, q.questiontitle, q.indate, q.outdate, '답변완료' result from question as q inner join answer as a "
					+ "on q.questionpk = a.question_questionpk "
					+ "inner join user as u on u.userpk = q.user_userpk "
					+ "union "
					+ "select q.questionpk, u.username, q.questiontitle, q.indate, q.outdate, '답변없음' result from question as q left join answer as a "
					+ "on q.questionpk = a.question_questionpk "
					+ "inner join user as u on u.userpk = q.user_userpk "
					+ "where a.question_questionpk is null ORDER BY questionpk DESC LIMIT ?, ?";
			int offset = requestPage - 1;
//			switch (button) {
//			case "Block":
//				query = query+"where not q.outdate is null";
//				break;
//			case "General":
//				query = query+"where q.outdate is null";
//				break;
//			case "All":
//			default:
//				break;
//			}
			
			preparedStatement = connection.prepareStatement(query);
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*numOfTuplesPerPage);
			}
			preparedStatement.setInt(2, numOfTuplesPerPage);
			resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				int questionpk = resultSet.getInt("questionpk");
				String username = resultSet.getString("username");
				String questiontitle = resultSet.getString("questiontitle");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
				String result = resultSet.getString("result");
			
				QnaDto dto = new QnaDto(questionpk, username, questiontitle, indate, outdate, result);
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
	/**
	 * 
	 * 1. MethodName        : AdminQnaView
	 * 2. ClassName         : AdminQnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 7:09:50
	 * @return AdminQnaDto
	 * @return
	 */
	public QnaDto AdminQnaView() {
		QnaDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select u.username, q.questionpk, q.questiontitle, q.questiontext, q.indate, q.outdate from question as q "
					+ "inner join user as u on u.userpk = q.user_userpk "
					+ "where questionpk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ShareVar.questionpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				String username = resultSet.getString("username");
				int questionpk = resultSet.getInt("questionpk");
				String questiontitle = resultSet.getString("questiontitle");
				String questiontext = resultSet.getString("questiontext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				dto = new QnaDto(questionpk, username, questiontitle, questiontext, indate, outdate); // bean 식으로 한줄로 만들기
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
	 * 1. MethodName        : AdminAnswerInsert
	 * 2. ClassName         : AdminQnaDao
	 * 3. Commnet           : Answer Insert Action
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 7:09:58
	 * @return void
	 * @param adminpk
	 * @param answertext
	 */
	public void AdminAnswerInsert(int adminpk, String answertext) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into answer(admin_adminpk, question_questionpk, answertext, indate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, adminpk);
			preparedStatement.setInt(2, ShareVar.questionpk);
			preparedStatement.setString(3, answertext);
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
	
	/**
	 * 
	 * 1. MethodName        : AdminAnswerList
	 * 2. ClassName         : AdminQnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 8:03:17
	 * @return ArrayList<AdminQnaDto>
	 * @return
	 */
	public ArrayList<QnaDto> AdminAnswerList() {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select * from answer as a "
					+ "inner join question as q on a.question_questionpk = q.questionpk "
					+ "inner join admin as ad on a.admin_adminpk = ad.adminpk "
					+ "where a.question_questionpk = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ShareVar.questionpk);
			resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				int answerpk = resultSet.getInt("answerpk");
				String adminid = resultSet.getString("adminid");
				String answertext = resultSet.getString("answertext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				QnaDto dto = new QnaDto(answerpk, adminid, answertext, indate, outdate);
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
	/**
	 * 
	 * 1. MethodName        : AdminAnswerBlock
	 * 2. ClassName         : AdminQnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 8:03:35
	 * @return void
	 * @param adminpk
	 * @param answertext
	 */
	public void AdminAnswerBlock(int answerpk, int check) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println(check);
		try {
			connection = dataSource.getConnection();
			String query = null;
			if (check == 1) {
				query = "update answer set outdate = null where answerpk = ?";
			}if (check == 0) {
				query = "update answer set outdate = now() where answerpk = ?";
			}
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, answerpk);

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
	//AdminAnswerView
	public QnaDto AdminAnswerView(int ianswerpk) {
		QnaDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from answer where answerpk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ianswerpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				int answerpk = resultSet.getInt("answerpk");
				String answertext = resultSet.getString("answertext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				dto = new QnaDto(answerpk, answertext, indate, outdate); // bean 식으로 한줄로 만들기
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
	 * 1. MethodName        : AdminAnswerUpdateAction
	 * 2. ClassName         : QnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 10:29:38
	 * @return void
	 * @param answerpk
	 * @param answertext
	 */
	public void AdminAnswerUpdateAction(int answerpk, String answertext) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update answer set answertext = ? where answerpk = ?";
		
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, answertext);
			preparedStatement.setInt(2, answerpk);

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
	/**
	 * 
	 * 1. MethodName        : UserQuestionInsert
	 * 2. ClassName         : QnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 10:29:42
	 * @return void
	 * @param userpk
	 * @param questiontitle
	 * @param questiontext
	 */
	public void UserQuestionInsert(int userpk, String questiontitle, String questiontext) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into question(user_userpk, questiontitle, questiontext, indate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userpk);
			preparedStatement.setString(2, questiontitle);
			preparedStatement.setString(3, questiontext);
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
	/**
	 * 
	 * 1. MethodName        : AdminQnAList
	 * 2. ClassName         : QnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 10:29:49
	 * @return ArrayList<QnaDto>
	 * @param button
	 * @return
	 */
	public ArrayList<QnaDto> UserQnAList(int userpk) {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select * from question as q "
					+ "inner join user as u on u.userpk = q.user_userpk "
					+ "where q.outdate is null and u.userpk = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userpk);
			resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				int questionpk = resultSet.getInt("questionpk");
				String username = resultSet.getString("username");
				String questiontitle = resultSet.getString("questiontitle");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				QnaDto dto = new QnaDto(questionpk, username, questiontitle, indate, outdate);
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
	public QnaDto UserQnaView() {
		QnaDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select u.username, q.questionpk, q.questiontitle, q.questiontext, q.indate, q.outdate from question as q "
					+ "inner join user as u on u.userpk = q.user_userpk "
					+ "where questionpk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ShareVar.questionpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				String username = resultSet.getString("username");
				int questionpk = resultSet.getInt("questionpk");
				String questiontitle = resultSet.getString("questiontitle");
				String questiontext = resultSet.getString("questiontext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				dto = new QnaDto(questionpk, username, questiontitle, questiontext, indate, outdate); // bean 식으로 한줄로 만들기
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
	 * 1. MethodName        : UserAnswerList
	 * 2. ClassName         : QnaDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 11:00:20
	 * @return ArrayList<QnaDto>
	 * @return
	 */
	public ArrayList<QnaDto> UserAnswerList() {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select * from answer as a "
					+ "inner join question as q on a.question_questionpk = q.questionpk "
					+ "inner join user as u on q.user_userpk = u.userpk "
					+ "where a.outdate is null and a.question_questionpk = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ShareVar.questionpk);
			resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				int answerpk = resultSet.getInt("answerpk");
				String adminid = resultSet.getString("adminid");
				String answertext = resultSet.getString("answertext");
				Timestamp indate = resultSet.getTimestamp("indate");
				Timestamp outdate = resultSet.getTimestamp("outdate");
			
				QnaDto dto = new QnaDto(answerpk, adminid, answertext, indate, outdate);
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
	
	public void UserQuestionBlock() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update question set outdate = now() where questionpk = ?";
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ShareVar.questionpk);

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
	public int countTuple() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		String query = "SELECT COUNT(*) FROM question";
		
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
				System.out.println("list-count success");
			}			
		} catch (Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				System.out.println("< rs, psmt, conn close Fail>");
			}
		}
		
		return count;
	}
}