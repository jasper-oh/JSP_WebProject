package com.project.mentoring.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.project.mentoring.dto.AdminReviewDto;
import com.project.mentoring.dto.ShareVar;
/**
 * 클래스설명 : Admin List에서 사용하는 모든 Dao
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.dao;
 */
public class AdminReviewDao {
	DataSource dataSource;
	public AdminReviewDao() {
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
	 * 1. MethodName        : AdminReviewList
	 * 2. ClassName         : AdminReviewDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 1:59:57
	 * @return ArrayList<AdminReviewDto>
	 * @return
	 */
	public ArrayList<AdminReviewDto> AdminReviewList(String button, String where, String keyword, int requestPage, int numOfTuplePerPage) {
		ArrayList<AdminReviewDto> dtos = new ArrayList<AdminReviewDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int offset = requestPage - 1;
		try {
			connection = dataSource.getConnection();
			String query = "select r.reviewpk, u.username, p.title, r.reviewtitle, reviewtext, r.reviewscore, r.indate, r.outdate from review as r "
					+ "inner join user as u on u.userpk = r.user_userpk "
					+ "inner join payment as py on py.paymentpk = r.payment_paymentpk "
					+ "inner join schedule as s on s.schedulepk=py.schedule_schedulepk "
					+ "inner join product as p on p.productpk = s.product_productpk ";
			//+ "where r.outdate is null and productpk = ?";
			switch (button) {
			case "Block":
				query = query+"where not r.outdate is null";
				break;
			case "General":
				query = query+"where r.outdate is null";
				break;
			case "All":
			default:
				break;
			}
			if(button == "All") {
				switch (where) {
				case "username":
					query = query+" where username like '%"+keyword+"%'";
					break;
				case "review":
					query = query+" where reviewtitle like '%"+keyword+"%' or reviewtext like '%"+keyword+"%'";
					break;
				case "title":
					query = query+" where title like '%"+keyword+"%'";
					break;
				case "null":
				default:
					break;
				}
			}else {
				switch (where) {
				case "username":
					query = query+" and username like '%"+keyword+"%'";
					break;
				case "review":
					query = query+" and reviewtitle like '%"+keyword+"%' or reviewtext like '%"+keyword+"%'";
					break;
				case "title":
					query = query+" and title like '%"+keyword+"%'";
					break;
				case "null":
				default:
					break;
				}
			}
			query = query + " ORDER BY r.indate DESC LIMIT ?, ? ;";
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*numOfTuplePerPage);
			}
			preparedStatement.setInt(2, numOfTuplePerPage);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int reviewpk = resultSet.getInt("reviewpk");
				String username = resultSet.getString("username");
				String title = resultSet.getString("title");
				String reviewtitle = resultSet.getString("reviewtitle");
				String reviewtext = resultSet.getString("reviewtext");
				int reviewscore = resultSet.getInt("reviewscore");
				Date indate = resultSet.getDate("indate");
				Date outdate = resultSet.getDate("outdate");
				AdminReviewDto dto = new AdminReviewDto(reviewpk, username, title, reviewtitle, reviewtext, reviewscore, indate, outdate);
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
	 * 1. MethodName        : AdminReviewBlind
	 * 2. ClassName         : AdminReviewDao
	 * 3. Commnet           : 
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 23. 오후 2:00:03
	 * @return void
	 * @param blindcheck
	 * @param reviewpk
	 */
	public void AdminReviewBlind(int blindcheck, int reviewpk) {
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			try {
				connection=dataSource.getConnection();
				String update = "";
				if (blindcheck == 0) {
					update="update review set outdate = now() where reviewpk = ?";	
				} else {
					update="update review set outdate = null where reviewpk = ?";	
				}
				preparedStatement=connection.prepareStatement(update);
				preparedStatement.setInt(1, reviewpk);  
				System.out.println(update);
				preparedStatement.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement!=null) preparedStatement.close();
					if(connection!=null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}		
	}
	/**
	 * 
	 * 1. MethodName        : countTuple
	 * 2. ClassName         : AdminReviewDao
	 * 3. Commnet           : list에서 사용하는 릴레이션이 가진 튜플의 총 갯수를 리턴한다.
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 24. 오후 4:17:30
	 * @return int
	 * @return
	 */
	public int countTuple() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		String query = "SELECT COUNT(*) FROM review";
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