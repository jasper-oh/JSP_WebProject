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

import com.project.mentoring.dto.AppointmentDto;
import com.project.mentoring.dto.MenteeDto;
import com.project.mentoring.dto.PaymentDto;
import com.project.mentoring.dto.ShareVar;



public class PaymentDao {
	DataSource dataSource;
	
	public PaymentDao() {
		try {
			Context context = new InitialContext();  //server context.xml연결
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentoringdb");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<PaymentDto> ProductSelect(){
		ArrayList<PaymentDto> dtos = new ArrayList<PaymentDto>();
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
				
				PaymentDto dto = new PaymentDto(username, majorname, submajorname, productpk); // bean 식으로 한줄로 만들기
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
	
	
	public PaymentDto PAppointment(int productpk) {
		PaymentDto dto = null;
		
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
			
				dto = new PaymentDto(username, majorname, submajorname, mentorgender, mentoraddress, mentorbirth); // bean 식으로 한줄로 만들기
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
	public PaymentDto PPayment(int userpk) {
		//MentoringFunction에서 랜덤 id 추출
		MentoringFunction mentoringFunction = new MentoringFunction();
		String strpaymentpk=Integer.toString(mentoringFunction.gen());
		//int userid = session.getAttribute("USERID"); 
		//병합과정에 추가하기!
		//추가 완료
		PaymentDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection=dataSource.getConnection();
			String query = "insert into payment(user_userpk, schedule_schedulepk, paymentpk, paymentpaydate) "
					+ "value (?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userpk);
			preparedStatement.setInt(2, ShareVar.schedulepk);
			preparedStatement.setString(3, strpaymentpk);
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
			preparedStatement.setString(1, strpaymentpk);
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				String paymentpk = resultSet.getString("paymentpk");
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
				
				dto = new PaymentDto(username, majorname, submajorname, starttime, endtime, startday, schedulepk, totalprice, title, paymentpk, paymentpaydate); // bean 식으로 한줄로 만들기
	
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
	public ArrayList<PaymentDto> ProductList(int userpk){
		ArrayList<PaymentDto> dtos = new ArrayList<PaymentDto>();
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
				  	+ "inner join user as u on u.userpk = m.user_userpk\n"
					+ "where u.userpk = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userpk);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int productpk = resultSet.getInt("p.productpk");
				String majorname = resultSet.getString("mj.majorname");
				String submajorname = resultSet.getString("s.submajorname");
				int username = resultSet.getInt("p.price");
				String title = resultSet.getString("p.title");
				
				PaymentDto dto = new PaymentDto(title, majorname, submajorname, productpk, username);
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

	public PaymentDto ProductPage(int id){
		
		PaymentDto dto = null;
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
				dto = new PaymentDto(title, majorname, submajorname, productpk, username, introduce);
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
	
	  * @변경이력 : createschedule 이름 변경 && 약간의 오류가 있는 거 같음
	
	  * @Method 설명 : mentor가 product에 schedule을 insert
	
	  * @param startday
	  * @param endday
	  * @param starttime
	  * @param endtime
	 */
	public void createschedule(String startday, String endday, String starttime, String endtime, int productpk) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int count = 0;
		int count2 = 0;
		try {
			connection=dataSource.getConnection();
			String select="SELECT DATEDIFF(?, ?), DATEDIFF(?, curdate())";
			preparedStatement=connection.prepareStatement(select);
			preparedStatement.setString(1, endday);
			preparedStatement.setString(2, startday);
			preparedStatement.setString(3, startday);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				 count = resultSet.getInt(1);
				 count2 = resultSet.getInt(2);
				}
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
				String query = "insert into schedule (product_productpk, startday, starttime, endtime, totalprice) values "
						+ "("+productpk+", DATE_ADD(curdate(), INTERVAL "+count2+" DAY), "+starttime+", "+endtime+", (select price from product where productpk = "+productpk+" )*("+endtime+" - "+starttime+")) ";
				String a = "";
				for (int i=count2+1; i<=count2+count; i++) {
					a = a+", ("+productpk+", DATE_ADD(curdate(), INTERVAL "+i+" DAY), "+starttime+", "+endtime+", (select price from product where productpk = "+productpk+" )*("+endtime+" - "+starttime+")) ";
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
	public PaymentDto scheduleselect(String strID) {
		
		PaymentDto dto=null;
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

				
				dto=new PaymentDto(pk, startday, starttime, endtime);
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
	
	  * @return
	 */
	public ArrayList<PaymentDto> productSchedulelist(int pk){
		ArrayList<PaymentDto> dtos=new ArrayList<PaymentDto>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;

		try {
			connection=dataSource.getConnection();
			String query="select schedulepk, if(CURDATE()-startday>0, 0, startday) startday, starttime, endtime, totalprice from schedule where startday>curdate() and product_productpk = ?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, pk);
			resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					int schedulepk=resultSet.getInt("schedulepk");
					Date startday=resultSet.getDate("startday");
					int starttime=resultSet.getInt("starttime");
					int endtime=resultSet.getInt("endtime");
					int totalprice=resultSet.getInt("totalprice");
					PaymentDto dto=new PaymentDto(schedulepk, startday, starttime, endtime, totalprice);
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
	public PaymentDto beforepayment(int schedulepk) {
		PaymentDto dto = null;
		
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
			
				dto = new PaymentDto(username, majorname, submajorname, starttime, endtime, startday, totalprice, title);// bean 식으로 한줄로 만들기
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
	 * @Method Name : MMenteeBookinglist
	 * @작성일 : 2021. 5. 20.
	 * @작성자 : chanhoLee, biso
	 * @변경이력 : case를 통해 표현할 데이터 변경
	 * @Method 설명 :
	 * @return
	 */
		public ArrayList<MenteeDto>  MMenteeBookinglist(String booking,int userpk) {
			ArrayList<MenteeDto> dtos=new ArrayList<MenteeDto>();
			System.out.println(booking);
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;

			// int userpk = session.getParameter("USERPK");
			// 병합시 유저피케이 넣어주기
			//완료
//			int userpk = 5;
			
			try {		
				connection=dataSource.getConnection();
				String query = null;
				switch (booking) {
				case "wait":
					query="select mentoruser.username as mentorname, mj.majorname, sb.submajorname, s.startday, s.starttime, s.endtime, py.paymentpk, py.paymentcanceldate, py.paymenttoken, py.paymentpaydate \n"
							+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
							+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
							+ " inner join product as p on s.product_productpk = p.productpk\n"
							+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
							+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
							+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
							+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
							+ " where py.paymentcanceldate is null and py.paymenttoken is null and mentee.userpk = ?";
					break;
				case "complite":
					query="select mentoruser.username as mentorname, mj.majorname, sb.submajorname, s.startday, s.starttime, s.endtime, py.paymentpk, py.paymentcanceldate, py.paymenttoken, py.paymentpaydate \n"
							+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
							+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
							+ " inner join product as p on s.product_productpk = p.productpk\n"
							+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
							+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
							+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
							+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
							+ " where not py.paymenttoken is null and mentee.userpk = ?";
					break;
				case "cancel":
					query="select mentoruser.username as mentorname, mj.majorname, sb.submajorname, s.startday, s.starttime, s.endtime, py.paymentpk, py.paymentcanceldate, py.paymenttoken, py.paymentpaydate\n"
							+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
							+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
							+ " inner join product as p on s.product_productpk = p.productpk\n"
							+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
							+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
							+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
							+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
							+ " where not py.paymentcanceldate is null and mentee.userpk = ?";
					break;
				case "null":
					query="select mentoruser.username as mentorname, mj.majorname, sb.submajorname, s.startday, s.starttime, s.endtime, py.paymentpk, py.paymentcanceldate, py.paymenttoken, py.paymentpaydate\n"
							+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
							+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
							+ " inner join product as p on s.product_productpk = p.productpk\n"
							+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
							+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
							+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
							+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
							+ " where py.paymentcanceldate is null and mentee.userpk = ?";
					break;
					
				default:
					break;
				}

				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, userpk);  
				resultSet=preparedStatement.executeQuery();
					while(resultSet.next()) {		
						String mentorname = resultSet.getString("mentorname");
						String majorname = resultSet.getString("majorname");
						String submajorname = resultSet.getString("submajorname");
						Date startday = resultSet.getDate("startday");
						int starttime = resultSet.getInt("starttime");
						int endtime = resultSet.getInt("endtime");
						String paymentpk = resultSet.getString("paymentpk");
						String paymenttoken = resultSet.getString("paymenttoken");
						Timestamp paymentcanceldate = resultSet.getTimestamp("paymentcanceldate");
						Timestamp paymentpaydate = resultSet.getTimestamp("paymentpaydate");
					
						MenteeDto dto=new MenteeDto(mentorname, majorname, submajorname, startday, starttime, endtime, paymentpk, paymenttoken, paymentcanceldate, paymentpaydate);		
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
		
	public void MenteeBookingCancel(String paymentpk){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=dataSource.getConnection();
			
			String update="update payment set paymentCanceldate = now() where paymentpk = ?";
			
			preparedStatement=connection.prepareStatement(update);
			preparedStatement.setString(1, paymentpk);  
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
	
	  * @Method Name : ProductReviewList
	
	  * @작성일 : 2021. 5. 21.
	
	  * @작성자 : biso
	
	  * @변경이력 : 
	
	  * @Method 설명 : productpage 하단에 review list를 불러옴
	
	  * @param productpk
	  * @return
	 */
	public ArrayList<AppointmentDto> ProductReviewList(int productpk) {
		ArrayList<AppointmentDto> dtos = new ArrayList<AppointmentDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select r.reviewpk, u.username, r.reviewtitle, r.reviewtext, r.reviewscore, r.indate from review as r "
					+ "inner join user as u on u.userpk = r.user_userpk "
					+ "inner join payment as py on py.paymentpk = r.payment_paymentpk "
				    + "inner join schedule as s on s.schedulepk=py.schedule_schedulepk "
					+ "inner join product as p on p.productpk = s.product_productpk "
					+ "where r.outdate is null and productpk = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productpk);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				int reviewpk = resultSet.getInt("reviewpk");
				String username = resultSet.getString("username");
				String reviewtitle = resultSet.getString("reviewtitle");
				String reviewtext = resultSet.getString("reviewtext");
				int reviewscore = resultSet.getInt("reviewscore");
				Date indate = resultSet.getDate("indate");
			
				AppointmentDto dto = new AppointmentDto(reviewpk, username, reviewtitle, reviewtext, reviewscore, indate);
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
	public void MMenteeMentoringReview(int userpk, String reviewtitle, String reviewtext, int reviewscore, String paymentpk) {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into review(user_userpk, reviewtitle, reviewtext, reviewscore, payment_paymentpk, indate) values (?,?,?,?,?,now())";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userpk);
			preparedStatement.setString(2, reviewtitle);
			preparedStatement.setString(3, reviewtext);
			preparedStatement.setInt(4, reviewscore);
			preparedStatement.setString(5, paymentpk);
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
	
	  * @Method Name : MMenteeReviewList
	
	  * @작성일 : 2021. 5. 21.
	
	  * @작성자 :chaho ree
	
	  * @변경이력 : 
	
	  * @Method 설명 :
	
	  * @return
	 */
	public ArrayList<MenteeDto>  MMenteeReviewList(int userpk) {
		ArrayList<MenteeDto> dtos=new ArrayList<MenteeDto>();
		System.out.println(1);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;

		System.out.println(2);
		try {		
			connection=dataSource.getConnection();
			String query="select mentoruser.username as mentorname, mj.majorname, p.title , r.reviewtitle, p.productpk, r.reviewpk\n"
					+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
					+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
					+ " inner join review as r on mentee.userpk = r.user_userpk\n"
					+ " inner join product as p on s.product_productpk = p.productpk\n"
					+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
					+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
					+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
					+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
					+ " where r.outdate is null and mentee.userpk = ?";
			
			System.out.println(3);
			preparedStatement=connection.prepareStatement(query);
			System.out.println(query);
			preparedStatement.setInt(1, userpk);  
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {		
				String mentorname = resultSet.getString("mentorname");
				String majorname = resultSet.getString("majorname");
				String title = resultSet.getString("title");
				String reviewtitle = resultSet.getString("reviewtitle");
				String productpk = resultSet.getString("productpk");
				int reviewpk = resultSet.getInt("reviewpk");
				
				
				
				MenteeDto dto=new MenteeDto(mentorname, majorname, title, reviewtitle, productpk,reviewpk);		
				dtos.add(dto);
				
				System.out.println(dtos);
				
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
	 * @Method Name : MMenteeBookingCompliteList
	 * @작성일 : 2021. 5. 21.
	 * @작성자 : chanhoLee
	 * @변경이력 : 
	 * @Method 설명 : 멘티 마이페이지의 과거 멘토링 내역
	 * @return
	 */
	public ArrayList<MenteeDto>  MMenteeMentoringList(int userpk) {
		ArrayList<MenteeDto> dtos=new ArrayList<MenteeDto>();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		// int userpk = session.getParameter("USERPK");
		// 병합시 유저피케이 넣어주기
		// 완료		
		//		int userpk = 4;
		
		try {		
			connection=dataSource.getConnection();
			String query="select mentoruser.username as mentorname, mj.majorname, sb.submajorname, s.startday, s.starttime, s.endtime, s.totalprice ,py.paymentpk\n"
					+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
					+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
					+ " inner join product as p on s.product_productpk = p.productpk\n"
					+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
					+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
					+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
					+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
					+ " where py.paymentCanceldate is null and not py.paymenttoken is null and not py.paymentsenddate is null and mentee.userpk = ?";
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, userpk);  
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {		
				String mentorname = resultSet.getString("mentorname");
				String majorname = resultSet.getString("majorname");
				String submajorname = resultSet.getString("submajorname");
				Date startday = resultSet.getDate("startday");
				int starttime = resultSet.getInt("starttime");
				int endtime = resultSet.getInt("endtime");
				int totalprice = resultSet.getInt("totalprice");
				String paymentpk = resultSet.getString("paymentpk");
				
				
				MenteeDto dto= new MenteeDto(mentorname, majorname, submajorname, startday, starttime, endtime, totalprice, paymentpk);		
				dtos.add(dto);
				
				System.out.println(dtos);
				
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
	 * @Method Name : MMenteeReviewEditPage
	 * @작성일 : 2021. 5. 21.
	 * @작성자 : chanhoLee
	 * @변경이력 : 
	 * @Method 설명 : 멘티의 리뷰 수정페이지
	 * @param reviewpk
	 * @return
	 */
	public ArrayList<MenteeDto> MMenteeReviewEditPage(int reviewpk) {
		ArrayList<MenteeDto> dtos=new ArrayList<MenteeDto>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {		
			connection=dataSource.getConnection();
			String query="select py.paymentpk, r.reviewtitle, r.reviewtext, r.reviewscore\n"
					+ "	from payment as py inner join schedule as s on py.schedule_schedulepk = s.schedulepk\n"
					+ " inner join user as mentee on mentee.userpk = py.user_userpk\n"
					+ " inner join review as r on mentee.userpk = r.user_userpk\n"
					+ " inner join product as p on s.product_productpk = p.productpk\n"
					+ " inner join mentor as m on p.mentor_mentorpk = m.mentorpk\n"
					+ " inner join user as mentoruser on m.user_userpk = mentoruser.userpk\n"
					+ " inner join submajor as sb on p.submajor_submajorpk = sb.submajorpk\n"
					+ " inner join major as mj on sb.major_majorpk = mj.majorpk\n"
					+ " where r.reviewpk = ?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, reviewpk);  
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {		
				String paymentpk = resultSet.getString("paymentpk");
				String reviewtitle = resultSet.getString("reviewtitle");
				String reviewtext = resultSet.getString("reviewtext");				
				int reviewscore = resultSet.getInt("reviewscore");
				MenteeDto dto=new MenteeDto(paymentpk, reviewtitle, reviewtext, reviewscore);		
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
	 * @Method Name : MMenteeReviewEditAction
	 * @작성일 : 2021. 5. 21.
	 * @작성자 : chanhoLee
	 * @변경이력 : 
	 * @Method 설명 :  멘티가 자신이 남겼던 리뷰를 수정할 때
	 * @param reviewpk
	 * @param paymentpk
	 * @param reviewtitle
	 * @param revietext
	 * @param strreviewscore
	 * @param reviewscore
	 */
	public void MMenteeReviewEditAction(int reviewpk, String paymentpk, String reviewtitle, String revietext, String strreviewscore, int reviewscore){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String update="update review set reviewtitle = ?, reviewtext = ?, reviewscore = ? where reviewpk = ?";
			preparedStatement=connection.prepareStatement(update);
			preparedStatement.setString(1, reviewtitle);  
			preparedStatement.setString(2, revietext);  
			preparedStatement.setInt(3, reviewscore);  
			preparedStatement.setInt(4, reviewpk);  
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
	 * @Method Name : MMenteeReviewDeleteAction
	 * @작성일 : 2021. 5. 21.
	 * @작성자 : chanhoLee
	 * @변경이력 : 
	 * @Method 설명 : 멘티가 자신이 등록한 리뷰를 삭제시 아웃데이트를 업데이트 시켜쥰다
	 * @param reviewpk
	 */
	public void MMenteeReviewDeleteAction(int reviewpk){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String update="update review set outdate = now() where reviewpk = ?";
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
	
	
	
	
}//----------------
