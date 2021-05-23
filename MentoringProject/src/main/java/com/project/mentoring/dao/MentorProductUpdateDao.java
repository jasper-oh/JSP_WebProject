package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MentorProductUpdateDao {
	DataSource dataSource;
	
	public MentorProductUpdateDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public int updateProduct(String productPk, String title, String price,String introduce) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String updateProductQuery1 = "update product set title = '" + title + "'";
			String updateProductQuery2 = " , introduce = '" + introduce + "'";
			String updateProductQuery3 = " , price = " + price;
			String updateProductQuery4 = " where productpk = ?";
			
			preparedStatement = connection.prepareStatement(updateProductQuery1 +updateProductQuery2 +updateProductQuery3+updateProductQuery4);
			
			preparedStatement.setString(1, productPk);
			
			preparedStatement.executeUpdate();
			System.out.println("777업데이트 완료");
			
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
	
}
