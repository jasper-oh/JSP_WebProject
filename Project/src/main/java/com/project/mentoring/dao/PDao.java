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

import com.project.mentoring.dto.PDto;
import com.project.mentoring.dto.ShareVar;
import com.project.mentoring.dto.PDto;


public class PDao {
	DataSource dataSource;
	
	public PDao() {
		try {
			Context context = new InitialContext();  //server context.xml연결
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<PDto> ProductSelect(){
		ArrayList<PDto> dtos = new ArrayList<PDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select u.username, mj.majorname, s.submajorname, p.productpk\n"
					+ "from product as p \n"
					+ "inner join mentor as m on m.mentorpk = p.mentor_mentorpk\n"
					+ " inner join submajor as s on p.submajor_submajorpk = s.submajorpk \n"
					+ "inner join major as mj on mj.majorpk=s.major_majorpk \n"
				  	+ "inner join user as u on u.userpk = m.user_userpk\n"
					+ "where m.outdate is null";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String username = resultSet.getString("u.username");
				String majorname = resultSet.getString("mj.majorname");
				String submajorname = resultSet.getString("s.submajorname");
				int productpk = resultSet.getInt("p.productpk");
				
				PDto dto = new PDto(username, majorname, submajorname, productpk); // bean 식으로 한줄로 만들기
				dtos.add(dto); // 한줄로만들어서  추가
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
	
	
	public PDto PAppointment(int productpk) {
		PDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select u.username, mj.majorname, s.submajorname, m.mentorgender, m.mentoraddress, m.mentorbirth from product as p "
					+ "inner join mentor as m on m.mentorpk = p.mentor_mentorpk "
					+ "inner join submajor as s on s.submajorpk = p.submajor_submajorpk "
				    + "inner join major as mj on mj.majorpk=s.major_majorpk "
					+ "inner join user as u on u.userpk = m.user_userpk "
					+ "where m.outdate is null and productpk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				String username = resultSet.getString("username");
				System.out.println(username);
				String majorname = resultSet.getString("majorname");
				String submajorname = resultSet.getString("submajorname");
				String mentorgender = resultSet.getString("mentorgender");
				String mentoraddress = resultSet.getString("mentoraddress");
				Date mentorbirth = resultSet.getDate("mentorbirth");
			
				dto = new PDto(username, majorname, submajorname, mentorgender, mentoraddress, mentorbirth); // bean 식으로 한줄로 만들기
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

  * @Method Name : PPayment

  * @작성일 : 2021. 5. 20.

  * @작성자 : biso

  * @변경이력 : 

  * @Method 설명 : payment table에 ShareVar.schedulepk/ShareVar.productpk/session.getAttribute("USERID") 입력

  * @param paymentpk
  * @return
 */
	public PDto PPayment() {
		//MentoringFunction에서 랜덤 id 추출
		MentoringFunction mentoringFunction = new MentoringFunction();
		int rdpaymentpk=mentoringFunction.gen();
		//int userid = session.getAttribute("USERID"); 
		//병합과정에 추가하기!
		PDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection=dataSource.getConnection();
			String query = "insert into payment(user_userpk, schedule_schedulepk, paymentpk, paymentpaydate) "
					+ "value (?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 4);
			preparedStatement.setInt(2, ShareVar.schedulepk);
			preparedStatement.setInt(3, rdpaymentpk);
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
		try {
			connection=dataSource.getConnection();
			String query2 = "select * from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk "
					+ "inner join user as mentee on mentee.userpk = py.user_userpk "
					+ "inner join product as p on s.product_productpk = p.productpk "
					+ "inner join mentor as m on p.mentor_mentorpk = m.mentorpk "
					+ "inner join user as mentoruser on m.user_userpk = mentoruser.userpk "
					+ "inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk "
					+ "inner join major as mj on sb.major_majorpk = mj.majorpk "
					+ "where py.paymentpk = ?";

			preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setInt(1, rdpaymentpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				int paymentpk = resultSet.getInt("paymentpk");
				int schedulepk = resultSet.getInt("schedule_schedulepk");
				Date paymentpaydate = resultSet.getDate("paymentpaydate");
				Date startday = resultSet.getDate("startday");
				int starttime = resultSet.getInt("starttime");
				int endtime = resultSet.getInt("endtime");
				int totalprice = resultSet.getInt("totalprice");
				String username = resultSet.getString("mentoruser.username");
				String title = resultSet.getString("title");
				String majorname = resultSet.getString("majorname");
				String submajorname = resultSet.getString("submajorname");
				
				dto = new PDto(username, majorname, submajorname, starttime, endtime, startday, schedulepk, totalprice, title, paymentpk, paymentpaydate); // bean 식으로 한줄로 만들기
	
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
	
	 * @Method Name : ProductList
	
	 * @작성일 : 2021. 5. 18.
	
	 * @작성자 : biso
	
	 * @변경이력 : 
	
	 * @Method 설명 : mentor mypage의 product 리스트
	
	 * @return
	 */
	public ArrayList<PDto> ProductList(){
		ArrayList<PDto> dtos = new ArrayList<PDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("ProductList()");
		try {
			connection = dataSource.getConnection();
			
			String query = "select mj.majorname, s.submajorname, p.productpk, p.price, p.title \n"
					+ "from product as p \n"
					+ "inner join mentor as m on m.mentorpk = p.mentor_mentorpk\n"
					+ " inner join submajor as s on p.submajor_submajorpk = s.submajorpk \n"
					+ "inner join major as mj on mj.majorpk=s.major_majorpk \n"
				  	+ "inner join user as u on u.userpk = m.user_userpk\n";
//					+ "where u.userpk = ? ";
			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int productpk = resultSet.getInt("p.productpk");
				String majorname = resultSet.getString("mj.majorname");
				String submajorname = resultSet.getString("s.submajorname");
				int username = resultSet.getInt("p.price");
				String title = resultSet.getString("p.title");
				
				PDto dto = new PDto(title, majorname, submajorname, productpk, username);
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

	public PDto ProductPage(int id){
		
		PDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			
			String query = "select mj.majorname, s.submajorname, p.productpk, p.price, p.title, p.introduce \n"
					+ "from product as p \n"
					+ "inner join mentor as m on m.mentorpk = p.mentor_mentorpk\n"
					+ " inner join submajor as s on p.submajor_submajorpk = s.submajorpk \n"
					+ "inner join major as mj on mj.majorpk=s.major_majorpk \n"
					+ "inner join user as u on u.userpk = m.user_userpk\n"
					+ "where p.productpk = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int productpk = resultSet.getInt("p.productpk");
				String majorname = resultSet.getString("mj.majorname");
				String submajorname = resultSet.getString("s.submajorname");
				int username = resultSet.getInt("p.price");
				String title = resultSet.getString("p.title");
				String introduce = resultSet.getString("p.introduce");
				dto = new PDto(title, majorname, submajorname, productpk, username, introduce);
				System.out.println("ProductPage()");
				System.out.println(title+ majorname+ submajorname+ productpk+ username+ introduce);
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
	
	  * @Method Name : creatschedule
	
	  * @작성일 : 2021. 5. 18.
	
	  * @작성자 : biso
	
	  * @변경이력 : 
	
	  * @Method 설명 : mentor가 product에 schedule을 insert
	
	  * @param startday
	  * @param endday
	  * @param starttime
	  * @param endtime
	 */
	public void creatschedule(String startday, String endday, String starttime, String endtime, int id) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int count = 0;
		
		try {
			connection=dataSource.getConnection();
			String select="SELECT DATEDIFF(?, ?)";
			preparedStatement=connection.prepareStatement(select);
			preparedStatement.setString(1, endday);
			preparedStatement.setString(2, startday);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				  count = resultSet.getInt(1);
				}
			System.out.println(count);
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
		
		Connection conn=null;
		PreparedStatement ps=null;	
			try {
				conn=dataSource.getConnection();
				String query = "INSERT INTO schedule (product_productpk, startday, starttime, endtime) values ("+id+", date_add('"+startday+"',INTERVAL 1 DAY), "+starttime+", "+endtime+") ";
				String a = "";
				
				for (int i=1; i<count; i++) {
					a = a+", ("+id+", date_add('"+startday+"', INTERVAL "+i+" DAY), "+starttime+", "+endtime+") ";
				}
				ps=conn.prepareStatement(query+a);
				ps.executeUpdate();
				System.out.println(query+a);
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
	
	  * @Method Name : scheduleselect
	
	  * @작성일 : 2021. 5. 18.
	
	  * @작성자 : biso
	
	  * @변경이력 : 
	
	  * @Method 설명 : product pk값에 등록된 스케쥴 중 today 이후의 값 select
	
	  * @param strID
	  * @return
	 */
	public PDto scheduleselect(String strID) {
		
		PDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=dataSource.getConnection();
			
			String query="select product_productpk, if(CURDATE()-startday>0, 0, startday) result, starttime, endtime from schedule where product_productpk = ?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int pk=resultSet.getInt(1);
				Date startday =resultSet.getDate(2);
				int starttime =resultSet.getInt(3);
				int endtime =resultSet.getInt(4);

				
				dto=new PDto(pk, startday, starttime, endtime);
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
		return dto;
	}
	/**
	 * 
	
	  * @Method Name : productSchedulelist
	
	  * @작성일 : 2021. 5. 18.
	
	  * @작성자 : biso
	
	  * @변경이력 : 
	
	  * @Method 설명 : user가 product페이지에서 	예약하기를 누르면 
	  * 해당 메소드로 productpk에 할당된 schedule을 가져옴
	  * 추가로 today이전 날짜 schedule을 삭제함
	
	  * @return
	 */
	public ArrayList<PDto> productSchedulelist(int pk){
		ArrayList<PDto> dtos=new ArrayList<PDto>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String delete="delete from schedule where startday<curdate()";
			preparedStatement=connection.prepareStatement(delete);
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
		//-------^delete
		try {
			connection=dataSource.getConnection();
			String query="select schedulepk, if(CURDATE()-startday>0, 0, startday) startday, starttime, endtime, totalprice from schedule where product_productpk = ?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, pk);
			resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					int schedulepk=resultSet.getInt("schedulepk");
					Date startday=resultSet.getDate("startday");
					int starttime=resultSet.getInt("starttime");
					int endtime=resultSet.getInt("endtime");
					int totalprice=resultSet.getInt("totalprice");
					PDto dto=new PDto(schedulepk, startday, starttime, endtime, totalprice);
					dtos.add(dto);
					System.out.println(startday);
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
	
	  * @Method Name : beforepayment
	
	  * @작성일 : 2021. 5. 20.
	
	  * @작성자 : biso
	
	  * @변경이력 : 
	
	  * @Method 설명 : payment 진행 전 정보 페이지 view
	
	  * @param productpk
	  * @return
	 */
	public PDto beforepayment(int schedulepk) {
		PDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select u.username, mj.majorname, sb.submajorname, p.title, s.startday, s.starttime, s.endtime, s.totalprice from schedule as s "
					+ "inner join product as p on p.productpk = s.product_productpk "
					+ "inner join mentor as m on m.mentorpk = p.mentor_mentorpk "
					+ "inner join submajor as sb on sb.submajorpk = p.submajor_submajorpk "
				    + "inner join major as mj on mj.majorpk=sb.major_majorpk "
					+ "inner join user as u on u.userpk = m.user_userpk "
					+ "where m.outdate is null and s.schedulepk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, schedulepk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				String username = resultSet.getString("username");
				String majorname = resultSet.getString("majorname");
				String submajorname = resultSet.getString("submajorname");
				String title = resultSet.getString("title");
				Date startday = resultSet.getDate("startday");
				int starttime = resultSet.getInt("starttime");
				int endtime = resultSet.getInt("endtime");
				int totalprice = resultSet.getInt("totalprice");
			
				dto = new PDto(username, majorname, submajorname, starttime, endtime, startday, totalprice, title);// bean 식으로 한줄로 만들기
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
}//----------------