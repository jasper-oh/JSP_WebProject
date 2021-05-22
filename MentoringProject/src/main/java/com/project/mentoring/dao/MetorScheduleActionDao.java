package com.project.mentoring.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.mentoring.dto.PaymentDto;
import com.project.mentoring.dto.ScheduleDto;

public class MetorScheduleActionDao {
	DataSource dataSource;
	
	public MetorScheduleActionDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * 
	 * 1. MethodName        : ScheduleListView
	 * 2. ClassName         : MetorScheduleActionDao
	 * 3. Commnet           : 멘토가 product에 등록한 스케쥴
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 22. 오후 5:31:41
	 * @return ArrayList<ScheduleDto>
	 * @param productpk
	 * @return
	 */
	public ArrayList<ScheduleDto> ScheduleListView(int productpk) {
		// TODO Auto-generated method stub
			ArrayList<ScheduleDto> dtos=new ArrayList<ScheduleDto>();
			System.out.println(productpk);
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			
			try {		
				connection=dataSource.getConnection();
				String query="select schedulepk, product_productpk, startday, starttime, endtime, totalprice from schedule "
						+ "where not schedulepk = any(select schedule_schedulepk from payment) and product_productpk = ? ORDER BY DATE(startday)";
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, productpk);
				resultSet=preparedStatement.executeQuery();
					while(resultSet.next()) {
						int schedulepk=resultSet.getInt("schedulepk");
						Date startday=resultSet.getDate("startday");
						int starttime=resultSet.getInt("starttime");
						int endtime=resultSet.getInt("endtime");
						int totalprice=resultSet.getInt("totalprice");
						ScheduleDto dto=new ScheduleDto(schedulepk, startday, starttime, endtime, totalprice);
						dtos.add(dto);
					}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet!=null) resultSet.close();
					if(preparedStatement!=null) preparedStatement.close();
					if(connection!=null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return dtos;
	}
	/**
	 * 
	 * 1. MethodName        : scheduleDeleteAction
	 * 2. ClassName         : MetorScheduleActionDao
	 * 3. Commnet           : 스케쥴 삭제 method
	 * 4. 작성자                       : biso
	 * 5. 작성일                       : 2021. 5. 22. 오후 5:34:27
	 * @return void
	 * @param schedulepk
	 */
	public void scheduleDeleteAction(int schedulepk){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String update="delete from schedule where schedulepk = ?";
			preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(1, schedulepk);  
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
	
	
}
