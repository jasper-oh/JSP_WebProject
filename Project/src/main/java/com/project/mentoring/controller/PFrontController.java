package com.project.mentoring.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.command.PScheduleInsertCommand;
import com.project.mentoring.command.MenteeBookingCancelCommand;
import com.project.mentoring.command.MenteeBookinglistCommand;
import com.project.mentoring.command.PAppointmentCommand;
import com.project.mentoring.command.PCommand;
import com.project.mentoring.command.PMentorProductListCommand;
import com.project.mentoring.command.PMentorProductPageCommand;
import com.project.mentoring.command.PPaymentcommand;
import com.project.mentoring.command.PProductSchedulViewCommand;
import com.project.mentoring.command.PProductScheduleSelectCommand;
import com.project.mentoring.command.PProductSelectCommand;




@WebServlet("*.do")
public class PFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo()");
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();  // /MVCBoard/start.do 이런식으로 가져오는게 uri "user request information"
		String conPath = request.getContextPath(); // /MVCBoard 이런식으로 프로젝트 이름만 가져오는게 contextPath
		String com = uri.substring(conPath.length()); // /start.do 이런식으로 가져옴 uri 에서 contextPath 를빼주면 원하는것만 가져온다  
		
		String viewPage = null;
		PCommand command = null;
		
		
		switch(com) {
			case("/mentorproductlist.do"):
				System.out.println("멘토 마이페이지 product");
				command=new PMentorProductListCommand();
				command.execute(request, response);
				viewPage="mentorproductlist.jsp";
				break;
			case("/mentorproductpage.do"):
				command=new PMentorProductPageCommand();
				command.execute(request, response);
				viewPage="mentorproductpage.jsp";
				break;
			case("/mentorscheduleinsert.do"):
				System.out.println("멘토 product 페이지");
				command=new PMentorProductListCommand();
				command.execute(request, response);
				viewPage="productinsertschedule.jsp";
				break;
			case("/insertscheduleview.do"):
				System.out.println("스케쥴 입력 선택");
				viewPage="insertscheduleview.jsp";
				break;
			case("/insertscheduleaction.do"):
				System.out.println("스케쥴 입력");
				command=new PScheduleInsertCommand();
				command.execute(request, response);
				viewPage="/mentorproductpage.do";
				break;
			case("/first.do"):
				System.out.println("유저 product 검색 list");
				command = new PProductSelectCommand();
				command.execute(request, response);
				viewPage="productselect.jsp";
				break;
			case("/appointment.do"):
				System.out.println("product 클릭 pageview");
				command = new PAppointmentCommand();
				command.execute(request, response);
				viewPage="appointment.jsp";
				break;
			case("/paymentscheduleselect.do"):
				System.out.println("예약하기 클릭 calendarview");
				command = new PProductSchedulViewCommand();
				command.execute(request, response);
				viewPage = "paymentscheduleselect.jsp";
				break;
			case("/paymentdatatview.do"):
				System.out.println("payment 전 정보 view");
				command = new PProductScheduleSelectCommand();
				command.execute(request, response);
				viewPage = "paymentdataview.jsp";
				break;
			case("/paymentsuccess.do"):
				System.out.println("payment db insert process");
				command = new PPaymentcommand();
				command.execute(request, response);
				viewPage = "paymentsuccess.jsp";
				break;
			case("/menteeBookingList.do"):
				System.out.println("멘티예약리스트로가기");
				command = new MenteeBookinglistCommand();
				command.execute(request, response);
				viewPage = "menteeBookingList.jsp";
				break;
				
			case("/menteeBookingCancel.do"):
				System.out.println("멘티가 예약 취소");
				command = new MenteeBookingCancelCommand();
				command.execute(request, response);
				viewPage = "menteeBookingList.do";
				break;
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}
}
