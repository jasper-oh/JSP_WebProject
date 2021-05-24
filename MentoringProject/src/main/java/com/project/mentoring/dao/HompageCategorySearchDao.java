package com.project.mentoring.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.project.mentoring.dto.HompageCategorySearchDto;
public class HompageCategorySearchDao {
	DataSource dataSource;
	public HompageCategorySearchDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<HompageCategorySearchDto> hompageCategorySearch(String strmajorname){
		ArrayList<HompageCategorySearchDto> hompageCategorySearchDtos = new ArrayList<HompageCategorySearchDto>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String Query = "select m.mentorimage , mj.majorname , p.title , s.submajorname ,p.productpk, u.username,p.price from product as p \n"
					+ "inner join mentor as m on m.mentorpk = p.mentor_mentorpk \n"
					+ "inner join submajor as s on p.submajor_submajorpk = s.submajorpk \n"
					+ "inner join major as mj on mj.majorpk=s.major_majorpk \n"
					+ "inner join user as u on u.userpk = m.user_userpk \n"
					+ "where m.outdate is null and mj.majorname = ?";
			prepareStatement = connection.prepareStatement(Query);
			prepareStatement.setString(1, strmajorname);
			System.out.println(prepareStatement);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				String mentorimage = resultSet.getString("mentorimage");
				String majorname = resultSet.getString("majorname");
				String title = resultSet.getString("title");
				String submajorname = resultSet.getString("submajorname");
				String productPk = resultSet.getString("productpk");
				String username = resultSet.getString("username");
				String price = resultSet.getString("price");
				HompageCategorySearchDto hompageCategorySearchDto = new HompageCategorySearchDto(mentorimage, majorname, title, submajorname, productPk, username, price);
				hompageCategorySearchDtos.add(hompageCategorySearchDto);
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
		return hompageCategorySearchDtos;
	}
}